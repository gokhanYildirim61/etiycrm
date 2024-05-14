package com.etiyacrm.customerservice.services.dtos.requests.contactMedium;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactMediumRequest {
    private String customerId;
    private String mobilePhone;
    private String homePhone;
    private String email;
    private String fax;
}
