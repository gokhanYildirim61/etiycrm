package com.etiyacrm.customerservice.services.dtos.requests.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3, max = 20, message = "City name size must be between 3 and 20 characters.")
    @Pattern(regexp = "^[çÇğĞıİöÖşŞüÜa-zA-Z]+$", message = "City name must not contain digits!")
    private String name;
}
