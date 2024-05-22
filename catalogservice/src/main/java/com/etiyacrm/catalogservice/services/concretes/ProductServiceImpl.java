package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.Product;
import com.etiyacrm.catalogservice.repositories.ProductRepository;
import com.etiyacrm.catalogservice.services.abstracts.ProductService;
import com.etiyacrm.catalogservice.services.dtos.requests.product.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.product.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;
import com.etiyacrm.catalogservice.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

        Product updatedProduct= ProductMapper.INSTANCE.productFromUpdateProductRequest(updateProductRequest);
        updatedProduct=productRepository.save(updatedProduct);
        UpdatedProductResponse updatedProductResponse=ProductMapper.INSTANCE.updatedProductResponseFromProduct(updatedProduct);
        return updatedProductResponse;
    }

    @Override
    public GetProductResponse getById(String id) {
        Product product=productRepository.findById(id).get();
        GetProductResponse getProductResponse=ProductMapper.INSTANCE.getProductResponseFromProduct(product);
        return getProductResponse;
    }

    @Override
    public GetAllProductResponse getAll() {
        List<Product> products = productRepository.findAll();

      GetAllProductResponse responses = ProductMapper.INSTANCE.getAllProductResponseFromProducts(products);
        return responses;
    }

    @Override
    public DeletedProductResponse softDelete(String id) {
        Product  product=productRepository.findById(id).get();
        product.setDeletedDate(LocalDateTime.now());
        productRepository.save(product);

        DeletedProductResponse deletedProductResponse=ProductMapper.INSTANCE.deletedProductResponseFromProduct(product);
        return  deletedProductResponse;

    }
}
