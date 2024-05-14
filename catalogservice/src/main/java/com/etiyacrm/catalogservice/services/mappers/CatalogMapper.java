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

    GetAllCatalogResponse getAllCatalogResponseFromCatalog(Catalog catalog);

    //asd
    Catalog catalogFromCreateCatalogRequest(CreateCatalogRequest createCatalogRequest);

    CreatedCatalogResponse createdCatalogResponseFromCatalog(Catalog catalog);
    Catalog catalogFromUpdateCatalogRequest(UpdateCatalogRequest updateCatalogRequest);

    UpdatedCatalogResponse updatedCatalogResponseFromCatalog(Catalog catalog);
    DeletedCatalogResponse deletedCatalogResponseFromCatalog(Catalog catalog);

    GetCatalogResponse getCatalogResponseFromCatalog(Catalog catalog);
}
