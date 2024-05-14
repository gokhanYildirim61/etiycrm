package com.etiyacrm.catalogservice.services.dtos.responses.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCatalogResponse {
    private String id;
    private String name;
}
