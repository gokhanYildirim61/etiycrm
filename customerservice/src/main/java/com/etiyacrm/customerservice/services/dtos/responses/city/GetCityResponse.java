package com.etiyacrm.customerservice.services.dtos.responses.city;

import com.etiyacrm.customerservice.entities.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCityResponse {


    private long id;

    private String name;

}
