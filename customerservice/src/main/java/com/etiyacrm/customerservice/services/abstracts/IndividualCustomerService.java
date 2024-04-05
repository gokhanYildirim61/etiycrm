package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.GetAllCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;

import java.util.List;

public interface IndividualCustomerService {

    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    GetIndividualCustomerResponse getById(long id);

    DeletedIndividualCustomerResponse softDelete(long id);

    GetListResponse<GetIndividualCustomerListResponse> getAllWithPaging(PageInfo pageInfo);

    List<GetIndividualCustomerListResponse> getAll(PageInfo pageInfo);
}
