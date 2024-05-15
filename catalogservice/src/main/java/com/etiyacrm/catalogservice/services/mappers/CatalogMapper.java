package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.Campaign;
import com.etiyacrm.catalogservice.entities.Catalog;
import com.etiyacrm.catalogservice.services.dtos.requests.catalog.CreateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalog.UpdateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaign.GetAllCampaignResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.catalog.*;
import com.etiyacrm.common.business.responses.GetListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    GetAllCatalogResponse getAllCatalogResponseFromCatalog(Catalog catalog);
    Catalog catalogFromCreateCatalogRequest(CreateCatalogRequest createCatalogRequest);
    CreatedCatalogResponse createdCatalogResponseFromCatalog(Catalog catalog);
    Catalog catalogFromUpdateCatalogRequest(UpdateCatalogRequest updateCatalogRequest);
    UpdatedCatalogResponse updatedCatalogResponseFromCatalog(Catalog catalog);
    DeletedCatalogResponse deletedCatalogResponseFromCatalog(Catalog catalog);
    GetCatalogResponse getCatalogResponseFromCatalog(Catalog catalog);
    @Mapping(source = "pageCatalog.content", target = "items")
    GetListResponse<GetAllCatalogResponse> pageInfoResponseFromPageCatalog(Page<Catalog> pageCatalog);
}
