package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.ProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("catalogservice/api/v1/productOffers")
public class ProductOfferController {
    private ProductOfferService productOfferService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedProductOfferResponse add(@Valid @RequestBody CreateProductOfferRequest createProductOfferRequest){
        return productOfferService.add(createProductOfferRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllProductOfferResponse> getAll(){
        return productOfferService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetProductOfferResponse getById(@PathVariable String id){
        return productOfferService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedProductOfferResponse update(@Valid @RequestBody UpdateProductOfferRequest updateProductOfferRequest){
        return productOfferService.update(updateProductOfferRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedProductOfferResponse delete(@PathVariable String id){
        return productOfferService.delete(id);
    }
}
