package com.etiyacrm.catalogservice.services.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductResponse {
    private String id;
    private String name;
    private String description;
}
