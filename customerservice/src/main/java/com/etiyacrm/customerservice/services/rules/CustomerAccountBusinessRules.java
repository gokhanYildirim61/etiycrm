package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.business.abstracts.MessageService;
import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.CustomerAccount;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerAccountBusinessRules {
    private MessageService messageService;
    public void checkDeletedDate(LocalDateTime localDateTime){
        if (localDateTime != null){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CustomerAccountErrors.CustomerAccountNotFound));
        }
    }

    public void checkCustomerAccount(Optional<CustomerAccount> customerAccount) {
        if (!customerAccount.isPresent()){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CustomerAccountErrors.CustomerAccountNotFound));
        }
    }
}
