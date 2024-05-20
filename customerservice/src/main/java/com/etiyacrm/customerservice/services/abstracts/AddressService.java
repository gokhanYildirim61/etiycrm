package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.adress.*;

import java.util.List;

public interface AddressService {

    List<GetAllAddressResponse> getAllWithCustomerId(String customerId);

    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);

    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest);

    GetAddressResponse getById(String id);

    GetListResponse<GetAllAddressResponse> getALLWithPaging(PageInfo pageInfo);

    DeletedAddressResponse softDelete(String id);


}
