package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.product.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.product.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;

public interface ProductService {

    CreatedProductResponse add(CreateProductRequest createProductRequest);

    UpdatedProductResponse update(UpdateProductRequest updateProductRequest);

    GetProductResponse getById(String id);

    GetAllProductResponse getAll();

    DeletedProductResponse softDelete(String id);
}
