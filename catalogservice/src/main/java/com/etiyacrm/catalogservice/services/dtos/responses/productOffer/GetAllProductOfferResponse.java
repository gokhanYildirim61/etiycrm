package com.etiyacrm.catalogservice.services.dtos.responses.productOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductOfferResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private String productId;
}
