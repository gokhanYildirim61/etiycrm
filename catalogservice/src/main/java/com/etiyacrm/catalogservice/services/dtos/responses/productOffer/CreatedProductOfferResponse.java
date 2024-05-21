package com.etiyacrm.catalogservice.services.dtos.responses.productOffer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedProductOfferResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private String productId;
}
