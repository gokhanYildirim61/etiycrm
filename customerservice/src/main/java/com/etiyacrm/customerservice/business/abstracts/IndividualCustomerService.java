package com.etiyacrm.customerservice.business.abstracts;

import com.etiyacrm.customerservice.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.customer.*;
import com.etiyacrm.customerservice.business.dtos.responses.individualCustomer.*;

import java.util.List;

public interface IndividualCustomerService {

    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    GetIndividualCustomerResponse getById(long id);

    List<GetIndividualCustomerListResponse> getAll();

    DeletedIndividualCustomerResponse softDelete(long id);
}
