package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.common.business.abstracts.MessageService;
import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressBusinessRules {
    private AddressRepository addressRepository;
    private CityService cityService;
    private MessageService messageService;

    public void checkDeletedDate(LocalDateTime localDateTime){
        if (localDateTime != null){
            throw new BusinessException(Messages.BusinessErrors.AddressErrors.AddressNotFound);
        }
    }

    public void checkCityExist(String cityId){
        if (!cityService.isCityExist(cityId)){
            throw new BusinessException(Messages.BusinessErrors.CityErrors.CityNotFound);
        }
    }

    public void checkAddress(Optional<Address> address){
        if (!address.isPresent()){
            throw new BusinessException(Messages.BusinessErrors.AddressErrors.AddressNotFound);
        }
    }
}
