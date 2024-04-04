package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.rules.CustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    CustomerBusinessRules customerBusinessRules;
    @Override
    public void findByEmailIgnoreCase(String email) {
        customerBusinessRules.customerEmailMustBeUnique(email);
    }

    @Override
    public Customer addWithEmail(String email) {
        Customer customer = new Customer();
        customer.setEmail(email);
        return customerRepository.save(customer);
    }
}
