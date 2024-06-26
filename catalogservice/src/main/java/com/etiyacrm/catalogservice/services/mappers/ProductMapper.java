package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.Product;
import com.etiyacrm.catalogservice.services.dtos.requests.product.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.product.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    GetAllProductResponse getAllProductResponseFromProducts(List<Product> products);
    Product productFromCreateProductRequest(CreateProductRequest createProductRequest);
    CreatedProductResponse createdProductResponseFromProduct(Product product);
    Product productFromUpdateProductRequest(UpdateProductRequest updateProductRequest);
    UpdatedProductResponse updatedProductResponseFromProduct(Product product);
    DeletedProductResponse deletedProductResponseFromProduct(Product product);
    GetProductResponse getProductResponseFromProduct(Product product);

//    @Mapping(source = "product.productOffer.id", target = "productOfferId")
//    @Mapping(source = "product.catalog.id", target = "catalogId")
//    @Mapping(source = "product.campaign.id", target = "campaignId")
//    GetProductResponse getProductResponse(Product product);
//
//    @Mapping(source = "product.productOffer.id", target = "productOfferId")
//    @Mapping(source = "product.catalog.id", target = "catalogId")
//    @Mapping(source = "product.campaign.id", target = "campaignId")
//    GetAllProductResponse getAllProductResponseFromProduct(Product product);
//
//
//    @Mapping(source = "productOfferId", target = "productOffer.id")
//    @Mapping(source = "catalogId", target = "catalog.id")
//    @Mapping(source = "campaignId", target = "campaign.id")
//    Product productFromCreateProductRequest(CreateProductRequest createProductRequest);
//
//    @Mapping(source = "product.productOffer.id", target = "productOfferId")
//    @Mapping(source = "product.catalog.id", target = "catalogId")
//    @Mapping(source = "product.campaign.id", target = "campaignId")
//    CreatedProductResponse createdProductResponseFromProduct(Product product);
//
//    @Mapping(source = "productOfferId", target = "productOffer.id")
//    @Mapping(source = "catalogId", target = "catalog.id")
//    @Mapping(source = "campaignId", target = "campaign.id")
//    Product productFromProductUpdatedProductRequest(UpdateProductRequest updateProductRequest);
//    @Mapping(source = "product.productOffer.id", target = "productOfferId")
//    @Mapping(source = "product.catalog.id", target = "catalogId")
//    @Mapping(source = "product.campaign.id", target = "campaignId")
//    UpdatedProductResponse updateProductResponseFromProduct(Product product);
//
//
//    @Mapping(source = "product.productOffer.id", target = "productOfferId")
//    @Mapping(source = "product.catalog.id", target = "catalogId")
//    @Mapping(source = "product.campaign.id", target = "campaignId")
//    DeletedProductResponse deleteProductResponseFromProduct(Product product);
//
//
//    @Mapping(source = "pageProduct.content", target = "items")
//    GetListResponse<GetAllProductResponse> pageInfoResponseFromPageProduct(Page<Product> pageProduct);
}
