package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.CreatedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.DeletedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.GetProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.UpdatedProductOfferResponse;

public interface ProductOfferService {
    CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest);
    UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest);
    GetProductOfferResponse getById(String id);
    DeletedProductOfferResponse softDelete(String id);
}
