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

    ContactMedium contactMediumFromCreateContactMediumRequest(CreateContactMediumRequest createContactMediumRequest);
    ContactMedium contactMediumFromUpdatedContactMediumRequest(UpdateContactMediumRequest updateContactMediumRequest);
    GetContactMediumResponse getContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    CreatedContactMediumResponse createdContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    UpdateContactMediumResponse updateContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    DeletedContactMediumResponse deleteContactMediumResponseFromContactMedium(ContactMedium contactMedium);

    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    GetContactMediumListResponse getAllContactMediumResponseFromContactMedium(ContactMedium contactMedium);

}
