package com.etiyacrm.basketservice.clients;

import com.etiyacrm.basketservice.dtos.responses.GetCatalogProductOfferResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "http://localhost:(catalogservice portu)/api/v1/catalog-product-offers")//gateway gelince catalaog-service eklenecek
public interface CatalogServiceClient {

    @GetMapping("/{id}")
    GetCatalogProductOfferResponse getById(@PathVariable String id);
}
