package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.IndividualCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, String> {

    Optional<IndividualCustomer> findByNationalityIdIgnoreCase(String nationalId);
    boolean existsByNationalityId(String nationalityId);
    Page<IndividualCustomer> findAllByDeletedDateIsNull(Pageable pageable);


}
