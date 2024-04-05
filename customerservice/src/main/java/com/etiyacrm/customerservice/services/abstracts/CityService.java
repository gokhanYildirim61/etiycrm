package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;

import java.util.List;

public interface CityService {
    List<GetAllCityResponse> getAll(PageInfo pageInfo);
    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update(UpdateCityRequest updateCityRequest);

    GetCityResponse getById(long id);

    GetListResponse<GetAllCityResponse> getAllWithPaging(PageInfo pageInfo);

    DeletedCityResponse softDelete(long id);

}
