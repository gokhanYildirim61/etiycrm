package com.etiyacrm.customerservice.services.dtos.responses.adress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAddressResponse {
    private String id;
    private String description;
    private String cityId;
    private String customerId;
    private String houseNumber;
    private String street;
}
