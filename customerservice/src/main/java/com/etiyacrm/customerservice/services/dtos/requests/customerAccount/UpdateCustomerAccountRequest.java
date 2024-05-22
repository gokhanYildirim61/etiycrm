package com.etiyacrm.customerservice.services.dtos.requests.customerAccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerAccountRequest {
    @NotBlank(message = "Account ID is required!")
    private String id;
    @NotNull(message = "Account Status is required!")
    private boolean status;
    @NotBlank(message = "Account Number is required!")
    private String number;
    @NotBlank(message = "Account Name is required!")
    private String name;
    @NotBlank(message = "Account Description is required!")
    private String description;
    @NotBlank(message = "Account Type is required!")
    private String type;
    @NotBlank(message = "Customer ID is required!")
    private String customerId;
    @NotBlank(message = "Address ID is required!")
    private String addressId; //+
}
