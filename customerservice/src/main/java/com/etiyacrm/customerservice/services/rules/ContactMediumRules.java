package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ContactMediumRules {
    public void checkDeletedDate(LocalDateTime localDateTime) {
        if (localDateTime != null){
            throw new BusinessException("The Contact Medium not found");
        }
    }

    public void checkCustomerDeletedDate(LocalDateTime localDateTime) {
        if (localDateTime != null){
            throw new BusinessException("The Customer not found");
        }
    }
}
