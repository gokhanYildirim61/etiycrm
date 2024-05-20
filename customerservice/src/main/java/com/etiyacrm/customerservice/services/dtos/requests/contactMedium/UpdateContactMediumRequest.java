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
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid mobile phone number format!")
    private String mobilePhone;
    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email format!")
    private String email;
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid home phone number format!")
    private String homePhone;
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid fax number format!")
    private String fax;
}
