package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.exceptions.types.BusinessException;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
//    public void customerEmailMustBeUnique(String email){
//        Optional<Customer> customer = customerRepository.findByEmailIgnoreCase(email.trim());
//
//        if(customer.isPresent()){
//            throw new BusinessException("Email already exists");
//        }
//    }
}
