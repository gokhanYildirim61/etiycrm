package com.etiyacrm.customerservice.services.dtos.requests.address;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    private String description;
    private long cityId;
    private long customerId;
    private String houseNumber;
    private String street;

}
