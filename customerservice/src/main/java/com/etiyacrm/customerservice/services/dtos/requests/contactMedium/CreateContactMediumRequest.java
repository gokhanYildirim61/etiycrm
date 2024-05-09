package com.etiyacrm.customerservice.services.dtos.requests.contactMedium;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactMediumRequest {
    //private long id;
    private String individualCustomerId;
    private String mobilePhone;
    private String homePhone;
    private String email;
    private String fax;
//    private Customer customer;

}
