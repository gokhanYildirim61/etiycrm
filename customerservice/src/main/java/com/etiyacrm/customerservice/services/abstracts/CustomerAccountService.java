package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.CreateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.UpdateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.customerAccount.*;

public interface CustomerAccountService {


    CreatedCustomerAccountResponse add(CreateCustomerAccountRequest createCustomerAccountRequest);

    UpdatedCustomerAccountResponse update(UpdateCustomerAccountRequest updateCustomerAccountRequest);

    GetCustomerAccountResponse getById(String id);

    GetListResponse<GetAllCustomerAccountResponse> getAllWithPaging(PageInfo pageInfo);

    DeletedCustomerAccountResponse softDelete(String id);
}
