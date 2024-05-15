package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.ProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.CreatedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.DeletedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.GetProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.UpdatedProductOfferResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("catalogservice/api/v1/productOffers")
public class ProductOfferController {
    private ProductOfferService productOfferService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedProductOfferResponse add(@Valid @RequestBody CreateProductOfferRequest createProductOfferRequest){
        return productOfferService.add(createProductOfferRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedProductOfferResponse update(@Valid @RequestBody UpdateProductOfferRequest updateProductOfferRequest){
        return productOfferService.update(updateProductOfferRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetProductOfferResponse getByID(@PathVariable String id){
        return productOfferService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedProductOfferResponse delete(@PathVariable String id){
        return productOfferService.softDelete(id);
    }
}
