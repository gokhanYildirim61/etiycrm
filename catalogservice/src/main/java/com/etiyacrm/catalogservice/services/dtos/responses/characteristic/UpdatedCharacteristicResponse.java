package com.etiyacrm.catalogservice.services.dtos.responses.characteristic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCharacteristicResponse {
    private String id;
    private String name;
    private String description;
}
