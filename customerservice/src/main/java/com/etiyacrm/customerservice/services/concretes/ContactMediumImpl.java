package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
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
    private CustomerRepository customerRepository;

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
        Customer customer = customerRepository.getById(createContactMediumRequest.getCustomerId());
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        contactMedium.setCustomer(customer);
        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);
        CreatedContactMediumResponse response = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
       response.setCustomerId(customer.getId());
        return null;
    }

    @Override
    public UpdateContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest) {
        return null;
    }

    @Override
    public GetContactMediumResponse getById(String id) {
        return null;
    }

    @Override
    public DeletedContactMediumResponse softDelete(String id) {
        return null;
    }
}
