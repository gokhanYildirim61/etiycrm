package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;


import java.util.List;

public interface IndividualCustomerService {

    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception;

    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    GetIndividualCustomerResponse getById(String id);

     List<GetIndividualCustomerListResponse> getAll(PageInfo pageInfo);

    DeletedIndividualCustomerResponse softDelete(String id);

   // GetListResponse<GetIndividualCustomerListResponse> getAllWithPaging(PageInfo pageInfo);

   // List<GetIndividualCustomerListResponse> getAll(PageInfo pageInfo);
}
