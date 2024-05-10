package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, String> {
    Page<Address> findAllByDeletedDateIsNull(Pageable pageable);
}
