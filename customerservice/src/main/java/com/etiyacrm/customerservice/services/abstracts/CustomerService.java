package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.customer.*;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void findByEmailIgnoreCase(String email);

    Customer addWithEmail(String email);
}
