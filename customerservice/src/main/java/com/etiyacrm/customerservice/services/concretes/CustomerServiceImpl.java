package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.rules.CustomerBusinessRules;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    CustomerBusinessRules customerBusinessRules;

    @Override
    public Customer getById(String id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer setDeletedDate(Customer customer) {
        return customerRepository.save(customer);

    }


}
