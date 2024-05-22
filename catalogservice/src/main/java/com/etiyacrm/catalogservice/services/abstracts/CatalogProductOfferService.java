package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.catalogProductOffer.CreateCatalogProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogProductOffer.UpdateCatalogProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.catalogProductOffer.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CatalogProductOfferService {
    CreatedCatalogProductOfferResponse add(CreateCatalogProductOfferRequest createCatalogProductOfferRequest);
    UpdatedCatalogProductOfferResponse update(UpdateCatalogProductOfferRequest updateCatalogProductOfferRequest, String id);
    List<GetAllCatalogProductOfferResponse> getAll();
    GetCatalogProductOfferResponse finByProductOfferId(String id);
    DeletedCatalogProductOfferResponse delete(String id);
}
