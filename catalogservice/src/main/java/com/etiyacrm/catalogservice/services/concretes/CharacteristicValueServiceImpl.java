package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.CharacteristicValue;
import com.etiyacrm.catalogservice.repositories.CharacteristicValueRepository;
import com.etiyacrm.catalogservice.services.abstracts.CharacteristicValueService;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristicValue.CreateCharacteristicValueRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristicValue.UpdateCharacteristicValueRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.characteristicValue.*;
import com.etiyacrm.catalogservice.services.mappers.CharacteristicValueMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacteristicValueServiceImpl implements CharacteristicValueService {
    private CharacteristicValueRepository characteristicValueRepository;

    @Override
    public CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest createCharacteristicValueRequest) {
        CharacteristicValue characteristicValue =
                CharacteristicValueMapper.INSTANCE.characteristicValueFromCreateCharacteristicValueRequest(createCharacteristicValueRequest);
        CharacteristicValue createdCharacteristicValue = characteristicValueRepository.save(characteristicValue);

        CreatedCharacteristicValueResponse createdCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.createdCharacteristicValueResponseFromCharacteristicValue(createdCharacteristicValue);

        return createdCharacteristicValueResponse;
    }

    @Override
    public UpdatedCharacteristicValueResponse update(UpdateCharacteristicValueRequest updateCharacteristicValueRequest, String id) {
        CharacteristicValue characteristicValue =
                CharacteristicValueMapper.INSTANCE.characteristicValueFromUpdateCharacteristicValueRequest(updateCharacteristicValueRequest);
        characteristicValue.setId(id);
        characteristicValue.setUpdatedDate(LocalDateTime.now());
        CharacteristicValue updatedCharacteristicValue = characteristicValueRepository.save(characteristicValue);

        UpdatedCharacteristicValueResponse updatedCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.updatedCharacteristicValueResponseFromCharacteristicValue(updatedCharacteristicValue);

        return updatedCharacteristicValueResponse;
    }

    @Override
    public List<GetAllCharacteristicValueResponse> getAll() {
        List<CharacteristicValue> characteristicValueList = characteristicValueRepository.findAll();
        List<GetAllCharacteristicValueResponse> getAllCharacteristicValueResponseList =
                characteristicValueList.stream().map(CharacteristicValueMapper.INSTANCE::getAllCharacteristicValueResponseFromCharacteristicValue)
                        .collect(Collectors.toList());

        return getAllCharacteristicValueResponseList;
    }

    @Override
    public GetCharacteristicValueResponse getById(String id) {
        CharacteristicValue characteristicValue = characteristicValueRepository.findById(id).get();
        GetCharacteristicValueResponse getCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.getCharacteristicValueResponseFromCharacteristicValue(characteristicValue);

        return getCharacteristicValueResponse;
    }

    @Override
    public DeletedCharacteristicValueResponse delete(String id) {
        CharacteristicValue characteristicValue = characteristicValueRepository.findById(id).get();
        characteristicValue.setId(id);
        characteristicValue.setDeletedDate(LocalDateTime.now());
        CharacteristicValue deletedCharacteristicValue = characteristicValueRepository.save(characteristicValue);
        DeletedCharacteristicValueResponse deletedCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.deletedCharacteristicValueResponseFromCharacteristicValue(deletedCharacteristicValue);

        return deletedCharacteristicValueResponse;
    }
}
