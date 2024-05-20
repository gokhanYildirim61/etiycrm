package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.ContactMedium;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public void checkContactMedium(Optional<ContactMedium> contactMedium) {
        if (!contactMedium.isPresent()){
            throw new BusinessException("The Contact Medium not found");
        }
    }
}
