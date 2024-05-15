package com.etiyacrm.customerservice.services.dtos.requests.address;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressRequest {
    @NotBlank(message = "ID is required to update!")
    private String id;
    @NotBlank(message = "Customer ID is required to update!")
    private String customerId;
    @NotBlank(message = "City ID is required to update!")
    private String cityId;
    @NotBlank(message = "Description is required to update!")
    private String description;
    @NotBlank(message = "House number is required to update!")
    private String houseNumber;
    @NotBlank(message = "Street is required to update!")
    private String street;
}
