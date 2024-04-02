package com.etiyacrm.customerservice.business.dtos.responses.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedIndividualCustomerResponse {
    private long id;
    private String message;

}


