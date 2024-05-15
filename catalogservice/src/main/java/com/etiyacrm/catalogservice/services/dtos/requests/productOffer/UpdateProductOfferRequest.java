package com.etiyacrm.catalogservice.services.dtos.requests.productOffer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductOfferRequest {
    @NotBlank(message = "ProductOffer id is required to update")
    private String id;
    @NotBlank(message = "ProductOffer name cannot be empty")
    private String name;
    @NotBlank(message = "ProductOffer description cannot be empty")
    private String description;
    @Min(value = 0, message = "ProductOffer price cannot be less than 0")
    private double price;
}
