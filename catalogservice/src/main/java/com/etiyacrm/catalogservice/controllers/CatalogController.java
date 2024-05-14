package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.CatalogService;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.catalogResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/catalogs")
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
    public UpdatedCatalogResponse update(@Valid @RequestBody UpdateCatalogRequest updateCatalogRequest,
                                         @PathVariable String id){
        return catalogService.update(updateCatalogRequest, id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
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
