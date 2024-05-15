package com.etiyacrm.customerservice.services.dtos.requests.contactMedium;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateContactMediumRequest {
    @NotBlank(message = "Contact Medium ID is required!")
    private String id;
    @NotBlank(message = "Mobile Phone is required!")
    private String mobilePhone;
    @NotBlank(message = "Home Phone is required!")
    private String homePhone;
    @NotBlank(message = "Email is required!")
    private String email;
    @NotBlank(message = "Fax is required!")
    private String fax;
}
