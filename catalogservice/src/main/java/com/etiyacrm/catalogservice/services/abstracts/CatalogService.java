package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.catalog.CreateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalog.UpdateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaign.GetAllCampaignResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.catalog.*;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;

import java.util.List;

public interface CatalogService {
    CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest);
    UpdatedCatalogResponse update(UpdateCatalogRequest updateCatalogRequest);
    GetListResponse<GetAllCatalogResponse> getAllWithPaging(PageInfo pageInfo);
    GetCatalogResponse getById(String id);
    DeletedCatalogResponse delete(String id);
}
