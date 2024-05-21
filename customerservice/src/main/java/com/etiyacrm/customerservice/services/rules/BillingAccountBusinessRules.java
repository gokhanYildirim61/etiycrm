package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.BillingAccount;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BillingAccountBusinessRules {
    public void checkDeletedDate(LocalDateTime localDateTime){
        if (localDateTime != null){
            throw new BusinessException(Messages.BusinessErrors.BillingAccountErrors.BillingAccountNotFound);
        }
    }

    public void checkBillingAccount(Optional<BillingAccount> billingAccount) {
        if (!billingAccount.isPresent()){
            throw new BusinessException(Messages.BusinessErrors.BillingAccountErrors.BillingAccountNotFound);
        }
    }
}
