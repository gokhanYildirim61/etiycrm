package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.adapters.CustomerCheckService;
import com.etiyacrm.customerservice.core.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerService customerService;
    private CustomerCheckService customerCheckService;

//    public void individualCustomerEmailMustBeUnique(String email){
//        customerService.findByEmailIgnoreCase(email);
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

    public void checkIfNationalIdExists(String nationalityId, String firstName, String lastName, int birthDate) throws Exception {

        if(!customerCheckService.checkIfRealPerson(nationalityId, firstName, lastName, birthDate)){
            throw new BusinessException("Not a valid person");
        }

    }
}
