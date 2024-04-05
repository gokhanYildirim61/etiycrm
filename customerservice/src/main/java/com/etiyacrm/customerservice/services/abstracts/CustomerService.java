package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.entities.Customer;

public interface CustomerService {

    void findByEmailIgnoreCase(String email);

    Customer addWithEmail(String email);
}
