package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.entities.Customer;

public interface CustomerService {

    Customer getById(String id);
    Customer setDeletedDate(Customer customer);
}
