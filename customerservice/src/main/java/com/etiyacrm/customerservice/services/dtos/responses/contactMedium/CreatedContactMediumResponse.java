package com.etiyacrm.customerservice.services.dtos.responses.contactMedium;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedContactMediumResponse {

    private String id;
    private String individualCustomerId;
    private String mobilePhone;
    private String homePhone;
    private String email;
    private String fax;
}
