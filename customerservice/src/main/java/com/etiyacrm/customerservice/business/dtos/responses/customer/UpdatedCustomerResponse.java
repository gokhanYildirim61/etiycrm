package com.etiyacrm.customerservice.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedCustomerResponse {

    private long id;
    private String eMail;

}
