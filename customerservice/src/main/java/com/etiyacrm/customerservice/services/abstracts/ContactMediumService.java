package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.UpdateContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.GetIndividualCustomerResponse;

public interface ContactMediumService {

    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);

    UpdateContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest);

    GetContactMediumResponse getById(long id);

    DeletedContactMediumResponse softDelete(long id);


}
