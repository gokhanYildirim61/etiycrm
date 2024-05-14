package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.catalogResponses.*;

import java.util.List;

public interface CatalogService {
    CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest);
    UpdatedCatalogResponse update(UpdateCatalogRequest updateCatalogRequest, String id);
    List<GetAllCatalogResponse> getAll();
    GetCatalogResponse getById(String id);
    DeletedCatalogResponse delete(String id);
}
