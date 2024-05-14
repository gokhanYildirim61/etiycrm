package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.business.abstracts.MessageService;
import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.messages.Messages;
import com.etiyacrm.customerservice.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityBusinessRules {
    private CityRepository cityRepository;
    private MessageService messageService;
    public void cityNameCannotBeDuplicatedWhenInserted(String name){
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);

        if (city.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CityNameExists));
        }

    }

    public void checkDeletedDate(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            throw new BusinessException("The city not found");
        }
    }

    public void validateCityName(String name){
        if(name.matches(".*\\d.*")){
            throw new BusinessException("City name must not contain digits");
        }
    }

    public void checkIfIdNotExists(String id){
        Optional<City> city=cityRepository.findById(id);
        if (!city.isPresent()){
            throw new BusinessException("check if cityId not exists");
        }
    }
}