package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactMediumRules {
    public void checkDeletedDate(LocalDateTime localDateTime) {
        if (localDateTime != null){
            throw new BusinessException(Messages.BusinessErrors.ContactMediumErrors.ContactMediumNotFound);
        }
    }

    public void checkCustomerDeletedDate(LocalDateTime localDateTime) {
        if (localDateTime != null){
            throw new BusinessException(Messages.BusinessErrors.CustomerErrors.CustomerNotFound);
        }
    }

    public void checkContactMedium(Optional<ContactMedium> contactMedium) {
        if (!contactMedium.isPresent()){
            throw new BusinessException(Messages.BusinessErrors.ContactMediumErrors.ContactMediumNotFound);
        }
    }
}
