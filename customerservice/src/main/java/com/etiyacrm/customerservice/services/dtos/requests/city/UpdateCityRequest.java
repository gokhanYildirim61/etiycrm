package com.etiyacrm.customerservice.services.dtos.requests.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCityRequest {

    private long id;
    private String name;
}
