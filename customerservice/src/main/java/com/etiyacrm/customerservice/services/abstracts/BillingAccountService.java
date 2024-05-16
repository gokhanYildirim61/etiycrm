package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccount.*;

public interface BillingAccountService {


    CreatedBillingAccountResponse add(CreateBillingAccountRequest createBillingAccountRequest);

    UpdatedBillingAccountResponse update(UpdateBillingAccountRequest updateBillingAccountRequest);

    GetBillingAccountResponse getById(String id);

    GetListResponse<GetAllBillingAccountResponse> getAllWithPaging(PageInfo pageInfo);

    DeletedBillingAccountResponse softDelete(String id);
}
