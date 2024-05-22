package com.etiyacrm.catalogservice.services.dtos.requests.catalogProductOffer;

import com.etiyacrm.catalogservice.entities.Catalog;
import com.etiyacrm.catalogservice.entities.ProductOffer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCatalogProductOfferRequest {
    private String productOfferId;
    private String catalogId;
}
