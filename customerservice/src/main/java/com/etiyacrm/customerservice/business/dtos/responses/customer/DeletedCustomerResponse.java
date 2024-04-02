package com.etiyacrm.customerservice.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedCustomerResponse {

    private long id;
    private String message;
}
