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

import java.util.List;


@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);


    // Request to Entity
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);

    City cityFromCityUpdatedCityRequest(UpdateCityRequest updateCityRequest);


    // Entity to Response
    GetCityResponse getCityResponse(City city);

    List<GetAllCityResponse> getAllCityResponseFromCityList(List<City>  cities);

    CreatedCityResponse createdCityResponseFromCity(City city);

    UpdatedCityResponse updateCityResponseFromCity(City city);

    DeletedCityResponse deleteCityResponseFromCity(City city);


}