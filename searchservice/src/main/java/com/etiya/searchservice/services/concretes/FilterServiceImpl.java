package com.etiya.searchservice.services.concretes;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.repository.FilterRepository;
import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiya.searchservice.services.response.GetAllCustomer;
import com.etiya.searchservice.services.rules.FilterBusinessRules;
import com.etiyacrm.common.utilities.results.PageableResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FilterServiceImpl implements FilterService {

    private final FilterRepository filterRepository;
    private final MongoTemplate mongoTemplate;
    private final FilterBusinessRules filterBusinessRules;

    @Override
    public void updateCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void add(Customer customer) {
        filterBusinessRules.normalizeCustomerNames(customer);
        this.filterRepository.save(customer);
    }

    @Override
    public PageableResponse<GetAllCustomer> search(
            String nationalityId, String id, String accountId,
            String firstName, String middleName, String lastName, String orderId, Pageable pageable) {

        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();

        addCriteria(criteria, "nationalityId", nationalityId);
        addCriteria(criteria, "id", id);
        addCriteria(criteria, "accountId", accountId);
        addNormalizedCriteria(criteria, "firstName", firstName);
        addNormalizedCriteria(criteria, "middleName", middleName);
        addNormalizedCriteria(criteria, "lastName", lastName);
        addCriteria(criteria, "orderId", orderId);

        criteria.add(Criteria.where("deletedDate").is(null));

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        long total = mongoTemplate.count(query, Customer.class);
        List<Customer> customers = mongoTemplate.find(query.with(pageable), Customer.class);
        List<GetAllCustomer> responses = customers.stream().map(this::mapToGetAllCustomer).collect(Collectors.toList());

        return createPageableResponse(pageable, total, responses);
    }

    private void addCriteria(List<Criteria> criteria, String field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            criteria.add(Criteria.where(field).regex(Pattern.compile(Pattern.quote(value), Pattern.CASE_INSENSITIVE)));
        }
    }

    private void addNormalizedCriteria(List<Criteria> criteria, String field, String value) {
        if (value != null && !value.trim().isEmpty()) {
            String normalizedValue = filterBusinessRules.normalize(value);
            criteria.add(Criteria.where(field).regex(Pattern.compile(normalizedValue, Pattern.CASE_INSENSITIVE)));
        }
    }

    private GetAllCustomer mapToGetAllCustomer(Customer customer) {
        String firstName = filterBusinessRules.capitalize(customer.getFirstName());
        String middleName = filterBusinessRules.capitalize(customer.getMiddleName());
        String lastName = filterBusinessRules.capitalize(customer.getLastName());

        return new GetAllCustomer(
                customer.getId(),
                firstName,
                middleName,
                lastName,
                customer.getNationalityId()
        );
    }

    private PageableResponse<GetAllCustomer> createPageableResponse(Pageable pageable, long total, List<GetAllCustomer> responses) {
        int totalPages = (int) Math.ceil((double) total / pageable.getPageSize());
        boolean hasNext = pageable.getPageNumber() + 1 < totalPages;

        PageableResponse<GetAllCustomer> result = new PageableResponse<>();
        result.setContent(responses);
        result.setPage(pageable.getPageNumber());
        result.setSize(pageable.getPageSize());
        result.setTotalElements(total);
        result.setTotalPages(totalPages);
        result.setHasNext(hasNext);

        return result;
    }
}
