package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.CatalogService;
import com.etiyacrm.catalogservice.services.dtos.requests.catalog.CreateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalog.UpdateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.catalog.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("catalogservice/api/v1/catalogs")
public class CatalogController {
    private CatalogService catalogService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCatalogResponse add(@Valid @RequestBody CreateCatalogRequest createCatalogRequest){
        return catalogService.add(createCatalogRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCatalogResponse update(@Valid @RequestBody UpdateCatalogRequest updateCatalogRequest){
        return catalogService.update(updateCatalogRequest);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getList")
    public List<GetAllCatalogResponse> getAll(){
        return catalogService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetCatalogResponse getById(@PathVariable String id){
        return catalogService.getById(id);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCatalogResponse delete(@PathVariable String id){
        return catalogService.delete(id);
    }

}
