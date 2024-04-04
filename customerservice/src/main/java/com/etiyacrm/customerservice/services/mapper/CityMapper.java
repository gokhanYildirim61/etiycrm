package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.CreatedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.city.GetAllCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    GetAllCityResponse getAllCityResponseFromCity(City city);
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);
    @Mapping(source = "pageCity.content", target = "items")
    GetListResponse<GetAllCityResponse> pageInfoResponseFromPageCity(Page<City> pageCity);
}
