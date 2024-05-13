package com.etiya.searchservice.kafka;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiyacrm.common.events.customers.CustomerCreatedEvent;
import com.etiyacrm.common.events.customers.CustomerUpdatedEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerUpdatedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreatedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-updated", groupId = "update-customer")
    private void consume(CustomerUpdatedEvent customerUpdatedEvent){
        Customer customer = new Customer();
        customer.setId(customerUpdatedEvent.getId());
        customer.setFirstName(customerUpdatedEvent.getFirstName());
        customer.setMiddleName(customerUpdatedEvent.getMiddleName());
        customer.setLastName(customerUpdatedEvent.getLastName());
        customer.setMotherName(customerUpdatedEvent.getMotherName());
        customer.setFatherName(customerUpdatedEvent.getFatherName());
        customer.setGender(customerUpdatedEvent.getGender());
        customer.setNationalityId(customerUpdatedEvent.getNationalityId());
        customer.setBirthDate(customerUpdatedEvent.getBirthDate());
        customer.setDeletedDate(customerUpdatedEvent.getDeletedDate());
        LOGGER.info(String.format("Customer updated event consumer => %s", customerUpdatedEvent.toString()));
        this.filterService.updateCustomer(customer);
    }
}
