package com.etiya.searchservice.services.abstracts;

import com.etiya.searchservice.entities.ContactMedium;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.services.response.GetAllCustomer;
import com.etiyacrm.common.utilities.results.PageableResponse;
import org.springframework.data.domain.Pageable;

public interface FilterService {
    void add(Customer customer);
    void updateCustomer(Customer customer);






    PageableResponse<GetAllCustomer> search(
            String nationalityId, String customerId, String accountId,
            String firstName, String middleName, String lastName,
            String orderId, Pageable pageable);
}
