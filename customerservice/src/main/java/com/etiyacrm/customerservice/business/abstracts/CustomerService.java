package com.etiyacrm.customerservice.business.abstracts;

import com.etiyacrm.customerservice.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.customer.*;

import java.util.List;

public interface CustomerService {

    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);

    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);

    GetCustomerResponse getById(long id);

    List<GetCustomerListResponse> getAll();

    DeletedCustomerResponse softDelete(long id);
}
