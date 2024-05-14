package com.etiyacrm.catalogservice.services.dtos.responses.productOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductOfferResponse {
    private String id;
    private String name;
    private String description;
    private double price;
}
