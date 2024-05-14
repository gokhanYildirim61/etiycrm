package com.etiyacrm.catalogservice.services.dtos.requests.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCatalogRequest {
    private String name;
}
