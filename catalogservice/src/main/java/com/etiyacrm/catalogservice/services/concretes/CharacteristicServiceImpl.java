package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.Characteristic;
import com.etiyacrm.catalogservice.repositories.CharacteristicRepository;
import com.etiyacrm.catalogservice.services.abstracts.CharacteristicService;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristic.CreateCharacteristicRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristic.UpdateCharacteristicRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.characteristic.*;
import com.etiyacrm.catalogservice.services.mappers.CharacteristicMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {
    private CharacteristicRepository characteristicRepository;

    @Override
    public CreatedCharacteristicResponse add(CreateCharacteristicRequest createCharacteristicRequest) {
        Characteristic characteristic =
                CharacteristicMapper.INSTANCE.characteristicFromCreateCharacteristicRequest(createCharacteristicRequest);
        Characteristic createdCharacteristic = characteristicRepository.save(characteristic);

        CreatedCharacteristicResponse createdCharacteristicResponse =
                CharacteristicMapper.INSTANCE.createdCharacteristicResponseFromCharacteristic(createdCharacteristic);

        return createdCharacteristicResponse;
    }

    @Override
    public UpdatedCharacteristicResponse update(UpdateCharacteristicRequest updateCharacteristicRequest, String id) {
        Characteristic characteristic =
                CharacteristicMapper.INSTANCE.characteristicFromUpdateCharacteristicRequest(updateCharacteristicRequest);
        characteristic.setId(id);
        characteristic.setUpdatedDate(LocalDateTime.now());
        Characteristic updatedCharacteristic = characteristicRepository.save(characteristic);

        UpdatedCharacteristicResponse updatedCharacteristicResponse =
                CharacteristicMapper.INSTANCE.updatedCharacteristicResponseFromCharacteristic(updatedCharacteristic);

        return updatedCharacteristicResponse;
    }

    @Override
    public List<GetAllCharacteristicResponse> getAll() {
        List<Characteristic> characteristicList = characteristicRepository.findAll();
        List<GetAllCharacteristicResponse> getAllCharacteristicResponseList =
                characteristicList.stream().map(CharacteristicMapper.INSTANCE::getAllCharacteristicResponseFromCharacteristic)
                        .collect(Collectors.toList());

        return getAllCharacteristicResponseList;
    }

    @Override
    public GetCharacteristicResponse getById(String id) {
        Characteristic characteristic = characteristicRepository.findById(id).get();
        GetCharacteristicResponse getCharacteristicResponse =
                CharacteristicMapper.INSTANCE.getCharacteristicResponseFromCharacteristic(characteristic);

        return getCharacteristicResponse;
    }

    @Override
    public DeletedCharacteristicResponse delete(String id) {
        Characteristic characteristic = characteristicRepository.findById(id).get();
        characteristic.setId(id);
        characteristic.setDeletedDate(LocalDateTime.now());
        Characteristic deletedCharacteristic = characteristicRepository.save(characteristic);

        DeletedCharacteristicResponse deletedCharacteristicResponse =
                CharacteristicMapper.INSTANCE.deletedCharacteristicResponseFromCharacteristic(deletedCharacteristic);

        return deletedCharacteristicResponse;
    }



}
