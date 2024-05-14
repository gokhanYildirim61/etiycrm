package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.*;
import com.etiyacrm.customerservice.services.mapper.ContactMediumMapper;
import com.etiyacrm.customerservice.services.rules.ContactMediumRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private ContactMediumRules contactMediumRules;
    private CustomerService customerService;

    @Override
    public List<GetContactMediumListResponse> getAll() {
        List<ContactMedium> contactMediumsList = this.contactMediumRepository.findAll();
        List<GetContactMediumListResponse> getAllContactMediumResponses = contactMediumsList.stream()
                .filter(contactMedium -> contactMedium.getDeletedDate() == null)
                .map(ContactMediumMapper.INSTANCE::getAllContactMediumResponseFromContactMedium).collect(Collectors.toList());
        return getAllContactMediumResponses;
    }

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        Customer customer = customerService.getById(createContactMediumRequest.getCustomerId());
        //contactMediumRules.checkCustomerDeletedDate(customer.getDeletedDate());
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        contactMedium.setCustomer(customer);
        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);
        CreatedContactMediumResponse response = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
        response.setCustomerId(customer.getId());
        return response;
    }

    @Override
    public UpdateContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest) {
        ContactMedium contactMedium = contactMediumRepository.findById(updateContactMediumRequest.getId()).get();
        //contactMediumRules.checkDeletedDate(contactMedium.getDeletedDate());
        ContactMedium updatedContactMedium = ContactMediumMapper.INSTANCE.contactMediumFromUpdatedContactMediumRequest(updateContactMediumRequest);
        System.out.println(contactMedium.getCustomer() == null);
        updatedContactMedium.setCustomer(contactMedium.getCustomer());
        updatedContactMedium = contactMediumRepository.save(updatedContactMedium);
        UpdateContactMediumResponse response = ContactMediumMapper.INSTANCE.updateContactMediumResponseFromContactMedium(updatedContactMedium);
        response.setCustomerId(updatedContactMedium.getCustomer().getId());
        return response;
    }

    @Override
    public GetContactMediumResponse getById(String id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        //contactMediumRules.checkDeletedDate(contactMedium.getDeletedDate());
        GetContactMediumResponse response = ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
        response.setCustomerId(contactMedium.getCustomer().getId());
        return response;
    }

    @Override
    public DeletedContactMediumResponse softDelete(String id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        //contactMediumRules.checkDeletedDate(contactMedium.getDeletedDate());
        contactMedium.setDeletedDate(LocalDateTime.now());
        contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.deleteContactMediumResponseFromContactMedium(contactMedium);
    }
}
