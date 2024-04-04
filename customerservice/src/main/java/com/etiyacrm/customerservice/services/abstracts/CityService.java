package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.CreatedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.city.GetAllCityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    List<GetAllCityResponse> getAll(PageInfo pageInfo);
    CreatedCityResponse add(CreateCityRequest createCityRequest);

    GetListResponse<GetAllCityResponse> getAllWithPaging(PageInfo pageInfo);

}
