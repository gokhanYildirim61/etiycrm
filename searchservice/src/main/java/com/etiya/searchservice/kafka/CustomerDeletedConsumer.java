package com.etiya.searchservice.kafka;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiyacrm.common.events.customers.CustomerDeletedEvent;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerDeletedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDeletedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-deleted", groupId = "delete-customer")
    private void consume(CustomerDeletedEvent customerDeletedEvent) {
        Customer customer = filterService.getById(customerDeletedEvent.getId());
        customer.setId(customerDeletedEvent.getId());
        customer.setDeletedDate(LocalDateTime.now());

        LOGGER.info(String.format("Customer deleted event consumer => %s", customerDeletedEvent.toString()));
        this.filterService.deleteCustomer(customer);
    }
}