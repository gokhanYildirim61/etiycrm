package com.etiyacrm.catalogservice.services.dtos.requests.productOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductOfferRequest {
    private String name;
    private String description;
    private double price;
}
