package com.etiyacrm.catalogservice.controllers;


import com.etiyacrm.catalogservice.services.abstracts.ProductService;
import com.etiyacrm.catalogservice.services.dtos.requests.product.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.product.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalogservice/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedProductResponse add(@RequestBody CreateProductRequest createProductRequest){
        return productService.add(createProductRequest);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedProductResponse updatedProductResponse(@RequestBody UpdateProductRequest updateProductRequest){
        return productService.update(updateProductRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetProductResponse getByID(@PathVariable String id ){
        return productService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetList")
    public GetListResponse<GetAllProductResponse> getAllWithPaging(PageInfo pageInfo) {
        return productService.getAllWithPaging(pageInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedProductResponse delete(@PathVariable String id){
        return  productService.softDelete(id);
    }





}
