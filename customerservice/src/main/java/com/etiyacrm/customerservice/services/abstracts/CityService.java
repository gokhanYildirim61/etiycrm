package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;

import java.util.List;

public interface CityService {

    List<GetAllCityResponse> getAll();
    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update(UpdateCityRequest updateCityRequest);

    GetCityResponse getById(String id);

    // City getByCityId(String id);

    DeletedCityResponse softDelete(String id);

    boolean isCityExist(String id);


}
