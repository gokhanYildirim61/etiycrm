package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {

    Optional<IndividualCustomer> findByNationalityIdIgnoreCase(String nationalId);

    Page<IndividualCustomer> findAllByDeletedDateIsNull(Pageable pageable);


}
