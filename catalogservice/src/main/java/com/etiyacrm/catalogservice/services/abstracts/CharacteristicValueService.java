package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.characteristicValue.CreateCharacteristicValueRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristicValue.UpdateCharacteristicValueRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.characteristicValue.*;

import java.util.List;

public interface CharacteristicValueService {
    CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest createCharacteristicValueRequest);
    UpdatedCharacteristicValueResponse update(UpdateCharacteristicValueRequest updateCharacteristicValueRequest, String id);
    List<GetAllCharacteristicValueResponse> getAll();
    GetCharacteristicValueResponse getById(String id);
    DeletedCharacteristicValueResponse delete(String id);
}
