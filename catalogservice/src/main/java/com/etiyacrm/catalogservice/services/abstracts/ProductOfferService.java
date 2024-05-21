package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.*;

import java.util.List;

public interface ProductOfferService {
    CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest);
    UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest);
    List<GetAllProductOfferResponse> getAll();
    GetProductOfferResponse getById(String id);
    DeletedProductOfferResponse delete(String id);
}
