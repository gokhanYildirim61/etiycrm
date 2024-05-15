package com.etiyacrm.catalogservice.services.dtos.requests.catalog;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCatalogRequest {
    @NotBlank(message = "Catalog id is required to update")
    private String id;
    @NotBlank(message = "Catalog name cannot be empty")
    private String name;
}
