package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.business.abstracts.MessageService;
import com.etiyacrm.common.exceptions.types.BusinessException;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
    private MessageService messageService;
    public void checkIfCustomerExists(String id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CustomerErrors.CustomerNotFound));
        }
    }
}
