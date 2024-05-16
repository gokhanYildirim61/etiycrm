package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAccountRepository  extends JpaRepository<BillingAccount,String> {
}
