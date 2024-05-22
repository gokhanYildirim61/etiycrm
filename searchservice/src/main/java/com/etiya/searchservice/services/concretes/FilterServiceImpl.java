package com.etiya.searchservice.services.concretes;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.repository.FilterRepository;
import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiya.searchservice.services.response.GetAllCustomer;
import com.etiyacrm.common.utilities.results.PageableResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void updateCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void add(Customer customer) {

        String normalizedFirstName = Normalizer.normalize(customer.getFirstName(), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        customer.setFirstName(normalizedFirstName);

        String normalizedMiddleName = Normalizer.normalize(customer.getMiddleName(), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        customer.setMiddleName(normalizedMiddleName);

        String normalizedLastName = Normalizer.normalize(customer.getLastName(), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        customer.setLastName(normalizedLastName);

        this.filterRepository.save(customer);

    }



    @Override
    public PageableResponse<GetAllCustomer> search(
            String nationalityId, String id, String accountId,
            String firstName, String middleName, String lastName, String orderId, Pageable pageable) {



        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();

        if (nationalityId != null && !nationalityId.trim().isEmpty()) {
            criteria.add(Criteria.where("nationalityId").regex(Pattern.compile(Pattern.quote(nationalityId), Pattern.CASE_INSENSITIVE)));
        }
        if (id != null && !id.trim().isEmpty()) {
            criteria.add(Criteria.where("id").regex(Pattern.compile(Pattern.quote(id), Pattern.CASE_INSENSITIVE)));
        }
        if (accountId != null && !accountId.trim().isEmpty()) {
            criteria.add(Criteria.where("accountId").regex(Pattern.compile(Pattern.quote(accountId), Pattern.CASE_INSENSITIVE)));
        }
        if (firstName != null && !firstName.trim().isEmpty()) {
            String normalizedFirstName = Normalizer.normalize(firstName, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
            criteria.add(Criteria.where("firstName").regex(Pattern.compile(normalizedFirstName, Pattern.CASE_INSENSITIVE)));
        }
        if (middleName != null && !middleName.trim().isEmpty()) {
            String normalizedMiddleName = Normalizer.normalize(middleName, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
            criteria.add(Criteria.where("middleName").regex(Pattern.compile(normalizedMiddleName, Pattern.CASE_INSENSITIVE)));
        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            String normalizedLastName = Normalizer.normalize(lastName, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
            criteria.add(Criteria.where("lastName").regex(Pattern.compile(normalizedLastName, Pattern.CASE_INSENSITIVE)));
        }
        if (orderId != null && !orderId.trim().isEmpty()) {
            criteria.add(Criteria.where("orderId").regex(Pattern.compile(Pattern.quote(orderId), Pattern.CASE_INSENSITIVE)));
        }

        criteria.add(Criteria.where("deletedDate").is(null));

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }

        long total = mongoTemplate.count(query, Customer.class);
        System.out.println("total: " + total);
        System.out.println("query: " + query);

        List<Customer> customers = mongoTemplate.find(query.with(pageable), Customer.class);
        List<GetAllCustomer> responses = customers.stream().map(customer -> {
            String firstNameTemp = customer.getFirstName();
            String middleNameTemp = customer.getMiddleName();
            String lastNameTemp = customer.getLastName();

            if (!firstNameTemp.isEmpty()) {
                firstNameTemp = firstNameTemp.substring(0, 1).toUpperCase() + firstNameTemp.substring(1);
            }

            if (!middleNameTemp.isEmpty()) {
                middleNameTemp = middleNameTemp.substring(0, 1).toUpperCase() + middleNameTemp.substring(1);
            }

            if (!lastNameTemp.isEmpty()) {
                lastNameTemp = lastNameTemp.substring(0, 1).toUpperCase() + lastNameTemp.substring(1);
            }

            return new GetAllCustomer(
                    customer.getId(),
                    firstNameTemp,
                    middleNameTemp,
                    lastNameTemp,
                    customer.getNationalityId()
            );
        }).collect(Collectors.toList());

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