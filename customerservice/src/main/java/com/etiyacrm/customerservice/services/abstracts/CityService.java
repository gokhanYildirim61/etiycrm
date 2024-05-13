package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;


import java.time.LocalDateTime;
import java.util.List;

public interface CityService {
    List<GetAllCityResponse> getAll(PageInfo pageInfo);
    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update(UpdateCityRequest updateCityRequest);

    GetCityResponse getById(String id);

    City getById2(String id);

    GetListResponse<GetAllCityResponse> getAllWithPaging(PageInfo pageInfo);

    DeletedCityResponse softDelete(String id);



}
