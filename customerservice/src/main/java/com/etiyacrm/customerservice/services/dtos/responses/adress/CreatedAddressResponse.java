package com.etiyacrm.customerservice.services.dtos.responses.adress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAddressResponse {
    private long id;
    private String description;
    private long cityId;
    private long customerId;
}
