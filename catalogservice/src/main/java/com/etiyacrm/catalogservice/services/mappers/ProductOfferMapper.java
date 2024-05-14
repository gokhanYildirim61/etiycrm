package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.ProductOffer;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.CreatedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.DeletedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.GetProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.UpdatedProductOfferResponse;
import org.mapstruct.factory.Mappers;

public interface ProductOfferMapper {
    ProductOfferMapper INSTANCE = Mappers.getMapper(ProductOfferMapper.class);

    GetProductOfferResponse getProductOfferResponseFromProductOffer(ProductOffer productOffer);
    ProductOffer productOfferFromCreateProductOfferRequest(CreateProductOfferRequest createProductOfferRequest);
    ProductOffer productOfferFromUpdateProductOfferRequest(UpdateProductOfferRequest updateProductOfferRequest);
    CreatedProductOfferResponse createdProductOfferResponseFromProductOffer(ProductOffer productOffer);
    UpdatedProductOfferResponse updatedProductOfferResponseFromProductOffer(ProductOffer productOffer);
    DeletedProductOfferResponse deleteProductOfferResponseFromProductOffer(ProductOffer productOffer);
}
