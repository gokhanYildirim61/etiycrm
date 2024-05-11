package com.etiyacrm.customerservice.services.dtos.requests.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressRequest {
    private String id;
    private String customerId;
    private String cityId;
    private String description;
    private String houseNumber;
    private String street;

}
