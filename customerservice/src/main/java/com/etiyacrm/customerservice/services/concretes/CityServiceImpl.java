package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;
import com.etiyacrm.customerservice.services.mapper.CityMapper;
import com.etiyacrm.customerservice.services.rules.CityBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CityBusinessRules cityBusinessRules;


    @Override
    public List<GetAllCityResponse> getAll() {
        List<City> cities=cityRepository.findAll();
        return CityMapper.INSTANCE.getAllCityResponseFromCityList(cities);
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        cityBusinessRules.cityNameCannotBeDuplicatedWhenInserted(createCityRequest.getName());
        City city = CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        City createdCity = cityRepository.save(city);
        return CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);
    }

    @Override
    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest) {
        cityBusinessRules.cityNameCannotBeDuplicatedWhenInserted(updateCityRequest.getName());
        Optional<City> cityOptional = cityRepository.findById(updateCityRequest.getId());
        cityBusinessRules.checkCity(cityOptional);
        City city = cityOptional.get();
        cityBusinessRules.checkDeletedDate(city.getDeletedDate());
        City updatedCity=CityMapper.INSTANCE.cityFromCityUpdatedCityRequest(updateCityRequest);
        updatedCity=cityRepository.save(updatedCity);
        return CityMapper.INSTANCE.updateCityResponseFromCity(updatedCity);
    }

    @Override
    public GetCityResponse getById(String id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        cityBusinessRules.checkCity(cityOptional);
        City city = cityOptional.get();
        GetCityResponse response = CityMapper.INSTANCE.getCityResponseFromCity(city);
        return response;
    }

    @Override
    public DeletedCityResponse softDelete(String id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        cityBusinessRules.checkCity(cityOptional);
        City city = cityOptional.get();
        cityBusinessRules.checkDeletedDate(city.getDeletedDate());
        city.setDeletedDate(LocalDateTime.now());
        cityRepository.save(city);
        return CityMapper.INSTANCE.deleteCityResponseFromCity(city);
    }

    @Override
    public boolean isCityExist(String id) {
        return cityRepository.existsById(id);
    }
}
