package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.UpdateContactMediumResponse;
import com.etiyacrm.customerservice.services.mapper.ContactMediumMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactMediumImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private IndividualCustomerRepository individualCustomerRepository;

//    @Override
//    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
//        //TODO(Business rules)
//        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
//        IndividualCustomer individualCustomer = individualCustomerRepository.getById(createContactMediumRequest.getIndividualCustomerId());
//        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);
//        createdContactMedium.setIndividualCustomer(individualCustomer);
//        CreatedContactMediumResponse response = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
//        return response;
//    }

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        IndividualCustomer individualCustomer = individualCustomerRepository.getById(createContactMediumRequest.getIndividualCustomerId());
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        contactMedium.setIndividualCustomer(individualCustomer);
        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);
        CreatedContactMediumResponse response = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
        response.setIndividualCustomerId(individualCustomer.getId());
        return response;
    }

    @Override
    public UpdateContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest) {
        return null;
    }

    @Override
    public GetContactMediumResponse getById(long id) {
        return null;
    }

    @Override
    public DeletedContactMediumResponse softDelete(long id) {
        return null;
    }
}
