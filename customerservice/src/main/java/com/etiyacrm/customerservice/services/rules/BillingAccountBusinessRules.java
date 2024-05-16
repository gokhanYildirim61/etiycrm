package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BillingAccountBusinessRules {
    public void checkDeletedDate(LocalDateTime localDateTime){
        if (localDateTime != null){
            throw new BusinessException("The billing account not found");
        }
    }
}
