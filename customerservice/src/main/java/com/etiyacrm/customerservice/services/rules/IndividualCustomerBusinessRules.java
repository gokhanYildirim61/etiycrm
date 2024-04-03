package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private IndividualCustomerRepository individualCustomerRepository;
//    public void individualCustomerEmailMustBeUnique(String email){
//        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByEmailIgnoreCase(email.trim());
//
//        if(individualCustomer.isPresent()){
//            throw new BusinessException("Email already exists");
//        }
//    }

    public void individualCustomerNationalityIdMustBeUnique(String nationalId){
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdIgnoreCase(nationalId.trim());

        if(individualCustomer.isPresent()){
            throw new BusinessException("National ID already exists");
        }
    }

    public void checkDeletedDate(LocalDateTime localDateTime){
        if (localDateTime != null){
            throw new BusinessException("The individual customer not found");
        }
    }


}
