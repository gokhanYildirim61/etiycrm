package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,String> {
}
