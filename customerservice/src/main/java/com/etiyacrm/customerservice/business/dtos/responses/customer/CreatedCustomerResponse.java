package com.etiyacrm.customerservice.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCustomerResponse {

    private long id;
    private String eMail;
}
