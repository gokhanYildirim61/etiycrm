package com.etiyacrm.catalogservice.services.dtos.requests.product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductRequest {
    @NotBlank(message = "Product id is required to update")
    private String id;

    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @NotBlank(message = "Product description cannot be empty")
    private String description;

}
