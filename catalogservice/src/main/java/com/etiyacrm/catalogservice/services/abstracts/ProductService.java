package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.product.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.product.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;

import java.util.List;

public interface ProductService {

    CreatedProductResponse add(CreateProductRequest createProductRequest);

    UpdatedProductResponse update(UpdateProductRequest updateProductRequest);

    GetProductResponse getById(String id);

    GetListResponse<GetAllProductResponse> getAllWithPaging(PageInfo pageInfo);

    DeletedProductResponse softDelete(String id);
}
