package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMediumMapper {
    ContactMediumMapper INSTANCE = Mappers.getMapper(ContactMediumMapper.class);

    @Mapping(source = "customerId", target = "customer.id")
    ContactMedium contactMediumFromCreateContactMediumRequest(CreateContactMediumRequest createContactMediumRequest);
    @Mapping(source = "customerId", target = "customer.id")
    ContactMedium contactMediumFromUpdatedContactMediumRequest(UpdateContactMediumRequest updateContactMediumRequest);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    GetContactMediumResponse getContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    CreatedContactMediumResponse createdContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    UpdateContactMediumResponse updateContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "contactMedium.customer.id", target = "id")
    DeletedContactMediumResponse deleteContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    GetContactMediumListResponse getAllContactMediumResponseFromContactMedium(ContactMedium contactMedium);

}
