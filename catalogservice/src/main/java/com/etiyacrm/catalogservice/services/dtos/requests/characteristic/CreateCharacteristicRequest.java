package com.etiyacrm.catalogservice.services.dtos.requests.characteristic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCharacteristicRequest {
    private String name;
    private String description;
}
