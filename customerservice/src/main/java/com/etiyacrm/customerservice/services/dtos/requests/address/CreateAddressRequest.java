package com.etiyacrm.customerservice.services.dtos.requests.address;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    @NotBlank(message = "Description is required!")
    private String description;
    @NotBlank(message = "City ID is required!")
    private String cityId;
    @NotBlank(message = "Customer ID is required!")
    private String customerId;
    @NotBlank(message = "House Number is required!")
    private String houseNumber;
    @NotBlank(message = "Street is required!")
    private String street;
}
