package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.Catalog;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.catalogResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    //@Mapping(source = "customer.id", target = "customerId")
    GetAllCatalogResponse getAllCatalogResponseFromCatalog(Catalog catalog);

    //@Mapping(source = "customerId", target = "customer.id")
    //@Mapping(source = "districtId", target = "district.id")
    Catalog catalogFromCreateCatalogRequest(CreateCatalogRequest createCatalogRequest);
    //@Mapping(source = "customer.id", target = "customerId")
    //@Mapping(source = "district.id", target = "districtId")
    CreatedCatalogResponse createdCatalogResponseFromCatalog(Catalog catalog);
    Catalog catalogFromUpdateCatalogRequest(UpdateCatalogRequest updateCatalogRequest);
    //@Mapping(source = "customer.id", target = "customerId")
    //@Mapping(source = "district.id", target = "districtId")
    UpdatedCatalogResponse updatedCatalogResponseFromCatalog(Catalog catalog);
    DeletedCatalogResponse deletedCatalogResponseFromCatalog(Catalog catalog);

    //@Mapping(source = "customer.id", target = "customerId")
    //@Mapping(source = "district.id", target = "districtId")
    GetCatalogResponse getCatalogResponseFromCatalog(Catalog catalog);
}
