package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;



@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    GetCityResponse getCityResponse(City city);
    GetAllCityResponse getAllCityResponseFromCity(City city);
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);
//
    City cityFromCityUpdatedCityRequest(UpdateCityRequest updateCityRequest);
    UpdatedCityResponse updateCityResponseFromCity(City city);

    DeletedCityResponse deleteCityResponseFromCity(City city);

    @Mapping(source = "pageCity.content", target = "items")
    GetListResponse<GetAllCityResponse> pageInfoResponseFromPageCity(Page<City> pageCity);
}