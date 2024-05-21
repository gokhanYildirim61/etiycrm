package com.etiyacrm.catalogservice.services.dtos.requests.productOffer;

import com.etiyacrm.catalogservice.entities.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductOfferRequest {
    @NotBlank(message = "ProductOffer name cannot be empty")
    private String name;

    @NotBlank(message = "ProductOffer description cannot be empty")
    private String description;


    @Min(value = 0, message = "ProductOffer price cannot be less than 0")
    private double price;

    @NotBlank(message = "ProductId cannot be empty")
    private String productId;

}
