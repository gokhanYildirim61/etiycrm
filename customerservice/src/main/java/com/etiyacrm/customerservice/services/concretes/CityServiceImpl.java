package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.CreatedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.city.GetAllCityResponse;
import com.etiyacrm.customerservice.services.mapper.CityMapper;
import com.etiyacrm.customerservice.services.rules.CityBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CityBusinessRules cityBusinessRules;
    @Override
    public List<GetAllCityResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<City> response = cityRepository.findAll(pageable);
//        return response.map(city -> CityMapper.INSTANCE.getAllCityResponseFromCity(city)).getContent();
        return response.map(CityMapper.INSTANCE::getAllCityResponseFromCity).getContent();
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        cityBusinessRules.cityNameCannotBeDuplicatedWhenInserted(createCityRequest.getName());
        City city = CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        City createdCity = cityRepository.save(city);
//        CreatedCityResponse response = CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);
//        return response;
        return CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);
    }

    @Override
    public GetListResponse<GetAllCityResponse> getAllWithPaging(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<City> response = cityRepository.findAllByDeletedDateIsNull(pageable);
        GetListResponse<GetAllCityResponse> responses = CityMapper.INSTANCE.pageInfoResponseFromPageCity(response);
        responses.setHasNext(response.hasNext());
        responses.setHasPrevious(response.hasPrevious());
        responses.setPage(pageInfo.getPage());
        return responses;
    }


}
