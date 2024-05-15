package com.etiyacrm.catalogservice.services.dtos.requests.productOffer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductOfferRequest {
    @NotBlank(message = "Product Offer name is required to update")
    private String name;
    private String description;
    @Min(value = 0, message = "The price cannot be less than 0")
    private double price;
}
