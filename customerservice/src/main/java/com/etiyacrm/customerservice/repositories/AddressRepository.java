package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    Page<Address> findAllByDeletedDateIsNull(Pageable pageable);
    List<Address> findAllByCustomerIdAndDeletedDateIsNull(String customerId);

}
