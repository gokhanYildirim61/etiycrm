package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.rules.CustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    CustomerBusinessRules customerBusinessRules;

    @Override
    public Customer getById(String id) {
        customerBusinessRules.checkIfCustomerExists(id);
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer setDeletedDate(Customer customer) {
        return customerRepository.save(customer);

    }


}
