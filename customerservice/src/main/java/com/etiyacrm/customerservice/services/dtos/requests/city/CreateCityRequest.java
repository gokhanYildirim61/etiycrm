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
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
}
