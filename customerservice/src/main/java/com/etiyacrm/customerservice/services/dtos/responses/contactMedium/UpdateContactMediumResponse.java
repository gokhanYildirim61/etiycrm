package com.etiyacrm.customerservice.services.dtos.responses.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateContactMediumResponse {
    private String id;
    private String customerId;
    private String mobilePhone;
    private String homePhone;
    private String email;
    private String fax;
}
