package com.etiyacrm.customerservice.services.dtos.requests.contactMedium;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactMediumRequest {
    @NotBlank(message = "Customer ID is required!")
    private String customerId;
    @NotBlank(message = "Mobile Phone is required!")
    private String mobilePhone;
    @NotBlank(message = "Home Phone is required!")
    private String homePhone;
    @NotBlank(message = "Email is required!")
    private String email;
    @NotBlank(message = "Fax is required!")
    private String fax;
}
