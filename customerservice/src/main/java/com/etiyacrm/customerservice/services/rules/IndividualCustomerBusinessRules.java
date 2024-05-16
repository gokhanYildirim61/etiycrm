package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.adapters.CustomerCheckService;
import com.etiyacrm.common.business.abstracts.MessageService;
import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CheckRealPersonRequest;
import com.etiyacrm.customerservice.services.messages.Messages;
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
    private MessageService messageService;



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

    public void checkIfIndividualCustomerExists(String id){
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(id);
        if (!individualCustomer.isPresent()){
            throw new BusinessException("The individual customer not found");
        }
    }

    public boolean checkIfRealPerson(CheckRealPersonRequest checkRealPersonRequest) throws Exception {
        return customerCheckService.checkIfRealPerson(checkRealPersonRequest.getNationalityId(), (checkRealPersonRequest.getFirstName() + " " + checkRealPersonRequest.getMiddleName()), checkRealPersonRequest.getLastName(), Integer.parseInt(checkRealPersonRequest.getBirthYear()));
    }

    public void checkIfNationalIdExists(String nationalityId, String firstName, String middleName, String lastName, int birthDate) throws Exception {

        if(!customerCheckService.checkIfRealPerson(nationalityId, (firstName + " " + middleName), lastName, birthDate)){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.IdentityNumberNotExists));
        }

    }
}
