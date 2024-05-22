package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.Characteristic;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristic.CreateCharacteristicRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristic.UpdateCharacteristicRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.characteristic.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacteristicMapper {
    CharacteristicMapper INSTANCE = Mappers.getMapper(CharacteristicMapper.class);

    GetAllCharacteristicResponse getAllCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    Characteristic characteristicFromCreateCharacteristicRequest(CreateCharacteristicRequest createCharacteristicRequest);

    CreatedCharacteristicResponse createdCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    Characteristic characteristicFromUpdateCharacteristicRequest(UpdateCharacteristicRequest updateCharacteristicRequest);

    UpdatedCharacteristicResponse updatedCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    DeletedCharacteristicResponse deletedCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    GetCharacteristicResponse getCharacteristicResponseFromCharacteristic(Characteristic characteristic);
}
