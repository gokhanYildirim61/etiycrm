package com.etiyacrm.catalogservice.services.dtos.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {

    private String name;
    private String description;
    private String productOfferId;
    private String catalogId;
    private String campaignId;
}
