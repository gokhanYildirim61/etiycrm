package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {
    // Optional<IndividualCustomer> findByEmailIgnoreCase(String email);
    Optional<IndividualCustomer> findByNationalityIdIgnoreCase(String nationalId);
}
