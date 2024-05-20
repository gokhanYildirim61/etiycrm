package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.*;
import com.etiyacrm.customerservice.services.mapper.ContactMediumMapper;
import com.etiyacrm.customerservice.services.rules.ContactMediumRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private ContactMediumRules contactMediumRules;

    @Override
    public GetContactMediumResponse getByCustomerId(String customerId) {
        ContactMedium contactMedium = contactMediumRepository.findByCustomerId(customerId);
        GetContactMediumResponse response = ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
        return response;
    }

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);
        CreatedContactMediumResponse response = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
        return response;
    }

    @Override
    public UpdateContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest) {
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromUpdatedContactMediumRequest(updateContactMediumRequest);
        ContactMedium updatedContactMedium = contactMediumRepository.save(contactMedium);
        UpdateContactMediumResponse response = ContactMediumMapper.INSTANCE.updateContactMediumResponseFromContactMedium(updatedContactMedium);
        return response;
    }

    @Override
    public GetContactMediumResponse getById(String id) {
        Optional<ContactMedium> contactMediumOptional = contactMediumRepository.findById(id);
        contactMediumRules.checkContactMedium(contactMediumOptional);
        ContactMedium contactMedium = contactMediumOptional.get();
        GetContactMediumResponse response = ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
        return response;
    }

    @Override
    public List<GetContactMediumListResponse> getAll() {
        List<ContactMedium> contactMediumsList = this.contactMediumRepository.findAll();
        List<GetContactMediumListResponse> getAllContactMediumResponses = contactMediumsList.stream()
                .filter(contactMedium -> contactMedium.getDeletedDate() == null)
                .map(ContactMediumMapper.INSTANCE::getAllContactMediumResponseFromContactMedium).collect(Collectors.toList());
        return getAllContactMediumResponses;
    }

    @Override
    public DeletedContactMediumResponse softDelete(String id) {
        Optional<ContactMedium> contactMediumOptional = contactMediumRepository.findById(id);
        contactMediumRules.checkContactMedium(contactMediumOptional);
        ContactMedium contactMedium = contactMediumOptional.get();
        contactMedium.setDeletedDate(LocalDateTime.now());
        contactMediumRepository.save(contactMedium);
        DeletedContactMediumResponse response = ContactMediumMapper.INSTANCE.deleteContactMediumResponseFromContactMedium(contactMedium);
        return response;
    }
}
