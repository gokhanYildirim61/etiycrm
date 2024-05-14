package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.Product;
import com.etiyacrm.catalogservice.services.dtos.requests.product.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.product.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;
import com.etiyacrm.common.business.responses.GetListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    GetProductResponse getProductResponse(Product product);

    GetAllProductResponse getAllProductResponseFromProduct(Product product);

    Product productFromCreateProductRequest(CreateProductRequest createProductRequest);

    CreatedProductResponse createdProductResponseFromProduct(Product product);

    Product productFromProductUpdatedProductRequest(UpdateProductRequest updateProductRequest);

    UpdatedProductResponse updateProductResponseFromProduct(Product product);

    DeletedProductResponse deleteProductResponseFromProduct(Product product);

    @Mapping(source = "pageProduct.content", target = "items")
    GetListResponse<GetAllProductResponse> pageInfoResponseFromPageProduct(Page<Product> pageProduct);
}
