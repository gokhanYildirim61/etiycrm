package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.*;

import java.util.List;

public interface ContactMediumService {

    List<GetContactMediumListResponse> getAll();
    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);
    UpdateContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest);
    GetContactMediumResponse getById(String id);
    DeletedContactMediumResponse softDelete(String id);
}
