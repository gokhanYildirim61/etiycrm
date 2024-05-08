package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //bu alanı ContactMediuma çektik

//    Optional<Customer> findByEmailIgnoreCase(String email);
}
