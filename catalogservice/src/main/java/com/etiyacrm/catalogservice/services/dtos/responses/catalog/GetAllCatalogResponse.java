package com.etiyacrm.catalogservice.services.dtos.responses.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCatalogResponse {
    private String id;
    private String name;
}
