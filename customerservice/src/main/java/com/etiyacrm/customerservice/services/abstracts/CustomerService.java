package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.customer.*;

import java.util.List;

public interface CustomerService {

    Customer findById(long id);

//    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);
//
//    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);
//
//    GetCustomerResponse getById(long id);
//
//    List<GetCustomerListResponse> getAll();
//
//    DeletedCustomerResponse softDelete(long id);
}
