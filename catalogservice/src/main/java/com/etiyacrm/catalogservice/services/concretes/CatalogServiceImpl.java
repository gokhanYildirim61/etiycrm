package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.Campaign;
import com.etiyacrm.catalogservice.entities.Catalog;
import com.etiyacrm.catalogservice.repositories.CatalogRepository;
import com.etiyacrm.catalogservice.services.abstracts.CatalogService;
import com.etiyacrm.catalogservice.services.dtos.requests.catalog.CreateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalog.UpdateCatalogRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaign.GetAllCampaignResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.catalog.*;
import com.etiyacrm.catalogservice.services.mappers.CampaignMapper;
import com.etiyacrm.catalogservice.services.mappers.CatalogMapper;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private CatalogRepository catalogRepository;
    @Override
    public CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest) {
        Catalog catalog = CatalogMapper.INSTANCE.catalogFromCreateCatalogRequest(createCatalogRequest);
        Catalog createdCatalog = catalogRepository.save(catalog);

        CreatedCatalogResponse createdCatalogResponse = CatalogMapper.INSTANCE.createdCatalogResponseFromCatalog(createdCatalog);

        return createdCatalogResponse;
    }

    @Override
    public UpdatedCatalogResponse update(UpdateCatalogRequest updateCatalogRequest) {
        Catalog catalog = CatalogMapper.INSTANCE.catalogFromUpdateCatalogRequest(updateCatalogRequest);
        catalog.setUpdatedDate(LocalDateTime.now());
        Catalog updatedCatalog = catalogRepository.save(catalog);

        UpdatedCatalogResponse updatedCatalogResponse = CatalogMapper.INSTANCE.updatedCatalogResponseFromCatalog(updatedCatalog);
        return updatedCatalogResponse;
    }

    @Override
    public GetListResponse<GetAllCatalogResponse> getAllWithPaging(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Catalog> response = catalogRepository.findAllByDeletedDateIsNull(pageable);
        GetListResponse<GetAllCatalogResponse> responses = CatalogMapper.INSTANCE.pageInfoResponseFromPageCatalog(response);
        responses.setHasNext(response.hasNext());
        responses.setHasPrevious(response.hasPrevious());
        responses.setPage(pageInfo.getPage());
        return responses;
    }

    @Override
    public GetCatalogResponse getById(String id) {
        Catalog catalog = catalogRepository.findById(id).get();
        GetCatalogResponse getCatalogResponse = CatalogMapper.INSTANCE.getCatalogResponseFromCatalog(catalog);

        return getCatalogResponse;
    }
    @Override
    public DeletedCatalogResponse delete(String id) {
            Catalog catalog = catalogRepository.findById(id).get();
            catalog.setId(id);
            catalog.setDeletedDate(LocalDateTime.now());
            Catalog deletedCatalog = catalogRepository.save(catalog);

            DeletedCatalogResponse deletedCatalogResponse =
                    CatalogMapper.INSTANCE.deletedCatalogResponseFromCatalog(deletedCatalog);

            return deletedCatalogResponse;
    }
}
