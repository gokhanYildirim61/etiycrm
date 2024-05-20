package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.*;

import java.util.List;

public interface ContactMediumService {

    GetContactMediumResponse getByCustomerId(String customerId);

    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);
    UpdateContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest);
    GetContactMediumResponse getById(String id);
    List<GetContactMediumListResponse> getAll();
    DeletedContactMediumResponse softDelete(String id);
}
