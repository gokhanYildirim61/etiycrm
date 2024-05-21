package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.ProductOffer;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductOfferMapper {
    ProductOfferMapper INSTANCE = Mappers.getMapper(ProductOfferMapper.class);

    @Mapping(source = "product.id", target = "productId")
    GetAllProductOfferResponse getAllProductOfferResponseFromProductOffer(ProductOffer productOffer);
    @Mapping(source = "productId" ,target = "product.id")
    ProductOffer productOfferFromCreateProductOfferRequest(CreateProductOfferRequest createProductOfferRequest);
    @Mapping(source = "product.id" ,target = "productId")
    CreatedProductOfferResponse createdProductOfferResponseFromProductOffer(ProductOffer productOffer);
    ProductOffer productOfferFromUpdateProductOfferRequest(UpdateProductOfferRequest updateProductOfferRequest);
    UpdatedProductOfferResponse updatedProductOfferResponseFromProductOffer(ProductOffer productOffer);
    DeletedProductOfferResponse deletedProductOfferResponseFromProductOffer(ProductOffer productOffer);
    GetProductOfferResponse getProductOfferResponseFromCProductOffer(ProductOffer productOffer);

//    GetProductOfferResponse getProductOfferResponseFromProductOffer(ProductOffer productOffer);
//    ProductOffer productOfferFromCreateProductOfferRequest(CreateProductOfferRequest createProductOfferRequest);
//    ProductOffer productOfferFromUpdateProductOfferRequest(UpdateProductOfferRequest updateProductOfferRequest);
//    CreatedProductOfferResponse createdProductOfferResponseFromProductOffer(ProductOffer productOffer);
//    UpdatedProductOfferResponse updatedProductOfferResponseFromProductOffer(ProductOffer productOffer);
//    DeletedProductOfferResponse deleteProductOfferResponseFromProductOffer(ProductOffer productOffer);
}
