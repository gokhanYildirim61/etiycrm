package com.etiyacrm.customerservice.services.dtos.requests.city;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCityRequest {
    @NotBlank(message = "City ID is required!")
    private String id;
    @NotBlank(message = "City name is required!")
    private String name;
}
