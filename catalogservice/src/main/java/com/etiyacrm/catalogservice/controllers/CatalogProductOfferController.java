package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.CatalogProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogProductOffer.CreateCatalogProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogProductOffer.UpdateCatalogProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.catalogProductOffer.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/catalogproductoffers")
public class CatalogProductOfferController {

    private CatalogProductOfferService catalogProductOfferService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCatalogProductOfferResponse add(@Valid @RequestBody CreateCatalogProductOfferRequest createCatalogProductOfferRequest) {
        return catalogProductOfferService.add(createCatalogProductOfferRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCatalogProductOfferResponse update(@Valid @RequestBody UpdateCatalogProductOfferRequest updateCatalogProductOfferRequest, @PathVariable String id) {
        return catalogProductOfferService.update(updateCatalogProductOfferRequest, id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllCatalogProductOfferResponse> getAll() {
        return catalogProductOfferService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetCatalogProductOfferResponse getById(@PathVariable String id) {
        return catalogProductOfferService.finByProductOfferId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCatalogProductOfferResponse delete(@PathVariable String id) {
        return catalogProductOfferService.delete(id);
    }
}