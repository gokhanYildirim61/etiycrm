package com.etiyacrm.catalogservice.services.dtos.responses.characteristicValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCharacteristicValueResponse {
    private String id;
    private String value;
    private boolean isActive;
    private String characteristicId;
}
