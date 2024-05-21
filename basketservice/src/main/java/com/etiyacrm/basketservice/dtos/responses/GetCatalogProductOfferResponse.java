package com.etiyacrm.basketservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCatalogProductOfferResponse {
    private String id;
    private String productOfferId;
    private String catalogId;
    private String catalogName;
}
