package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.adress.*;
import com.etiyacrm.customerservice.services.dtos.responses.city.UpdatedCityResponse;

public interface AddressService {

    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);

    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest);

    GetAddressResponse getById(String id);

    GetListResponse<GetAllAddressResponse> getALLWithPaging(PageInfo pageInfo);

    DeletedAddressResponse softDelete(String id);


}
