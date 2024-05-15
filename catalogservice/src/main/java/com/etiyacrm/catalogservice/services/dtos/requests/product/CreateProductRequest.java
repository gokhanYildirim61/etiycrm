package com.etiyacrm.catalogservice.services.dtos.requests.product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {
    @NotBlank(message = "Product name cannot be empty")
    private String name;
    @NotBlank(message = "Product description cannot be empty")
    private String description;
    @NotBlank(message = "Product productOfferId cannot be empty")
    private String productOfferId;
    @NotBlank(message = "Product catalogId cannot be empty")
    private String catalogId;
    @NotBlank(message = "Product campaignId cannot be empty")
    private String campaignId;
}
