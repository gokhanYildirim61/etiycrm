package com.etiyacrm.customerservice.services.dtos.requests.contactMedium;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateContactMediumRequest {
    @NotBlank(message = "Contact Medium ID is required!")
    private String id;
    @NotBlank(message = "Customer ID is required!")
    private String customerId;
    @NotBlank(message = "Mobile Phone is required!")
    @Pattern(regexp = "^(05|5)([0-9]{9})$", message = "Invalid mobile phone format!")
    private String mobilePhone;
    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email format!")
    private String email;
    private String homePhone;
    private String fax;
}
