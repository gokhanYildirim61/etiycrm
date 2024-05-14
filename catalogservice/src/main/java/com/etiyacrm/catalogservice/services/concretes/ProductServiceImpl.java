package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.Product;
import com.etiyacrm.catalogservice.repositories.ProductRepository;
import com.etiyacrm.catalogservice.services.abstracts.ProductService;
import com.etiyacrm.catalogservice.services.dtos.requests.product.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.product.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;
import com.etiyacrm.catalogservice.services.mappers.ProductMapper;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService {
    private ProductRepository productRepository;

    @Override
    public CreatedProductResponse add(CreateProductRequest createProductRequest) {
        Product product = ProductMapper.INSTANCE.productFromCreateProductRequest(createProductRequest);
        Product createdProduct=productRepository.save(product);

        CreatedProductResponse createdProductResponse=ProductMapper.INSTANCE.createdProductResponseFromProduct(createdProduct);

        return createdProductResponse;
    }

    @Override
    public UpdatedProductResponse update(UpdateProductRequest updateProductRequest) {
        Product product =productRepository.findById(updateProductRequest.getId()).get();
        Product updatedProduct= ProductMapper.INSTANCE.productFromProductUpdatedProductRequest(updateProductRequest);
        updatedProduct=productRepository.save(updatedProduct);

        return ProductMapper.INSTANCE.updateProductResponseFromProduct(updatedProduct);
    }

    @Override
    public GetProductResponse getById(String id) {
        Product product=productRepository.findById(id).get();
        GetProductResponse getProductResponse=ProductMapper.INSTANCE.getProductResponse(product);
        return getProductResponse;
    }

    @Override
    public GetListResponse<GetAllProductResponse> getAllWithPaging(PageInfo pageInfo) {
        return null;
    }

    @Override
    public DeletedProductResponse softDelete(String id) {
        Product  product=productRepository.findById(id).get();
        product.setDeletedDate(LocalDateTime.now());
        productRepository.save(product);

        DeletedProductResponse deletedProductResponse=ProductMapper.INSTANCE.deleteProductResponseFromProduct(product);
        return  deletedProductResponse;

    }
}
