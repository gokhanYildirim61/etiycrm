package com.etiyacrm.customerservice.services.dtos.requests.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCityRequest {
    @NotBlank(message = "City name is required!")
    @Size(min = 3, max = 20, message = "City name size must be between 3 and 20 characters.")
    private String name;
}
