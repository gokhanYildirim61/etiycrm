package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.Campaign;
import com.etiyacrm.catalogservice.repositories.CampaignRepository;
import com.etiyacrm.catalogservice.services.abstracts.CampaignService;
import com.etiyacrm.catalogservice.services.dtos.requests.campaign.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaign.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaign.*;
import com.etiyacrm.catalogservice.services.mappers.CampaignMapper;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {
    private CampaignRepository campaignRepository;

    @Override
    public CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest) {
        Campaign campaign = CampaignMapper.INSTANCE.campaignFromCreateCampaignRequest(createCampaignRequest);
        Campaign createdCampaign = campaignRepository.save(campaign);

        CreatedCampaignResponse createdCampaignResponse = CampaignMapper.INSTANCE.createdCampaignResponseFromCampaign(createdCampaign);

        return createdCampaignResponse;
    }

    @Override
    public UpdatedCampaignResponse update(UpdateCampaignRequest updateCampaignRequest) {
        Campaign campaign = campaignRepository.findById(updateCampaignRequest.getId()).get();
        Campaign updatedCampaign = CampaignMapper.INSTANCE.campaignFromCampaignUpdatedCampaignRequest(updateCampaignRequest);
        updatedCampaign = campaignRepository.save(updatedCampaign);

        return CampaignMapper.INSTANCE.updateCampaignResponseFromCampaign(updatedCampaign);
    }

    @Override
    public GetCampaignResponse getById(String id) {
        Campaign campaign = campaignRepository.findById(id).get();
        GetCampaignResponse getCampaignResponse = CampaignMapper.INSTANCE.getCampaignResponse(campaign);
        return getCampaignResponse;
    }

    @Override
    public GetListResponse<GetAllCampaignResponse> getAllWithPaging(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Campaign> response = campaignRepository.findAllByDeletedDateIsNull(pageable);
        GetListResponse<GetAllCampaignResponse> responses = CampaignMapper.INSTANCE.pageInfoResponseFromPageCampaign(response);
        responses.setHasNext(response.hasNext());
        responses.setHasPrevious(response.hasPrevious());
        responses.setPage(pageInfo.getPage());
        return responses;
    }


    @Override
    public DeletedCampaignResponse softDelete(String id) {
        Campaign campaign = campaignRepository.findById(id).get();
        campaign.setDeletedDate(LocalDateTime.now());
        campaignRepository.save(campaign);

        DeletedCampaignResponse deletedCampaignResponse = CampaignMapper.INSTANCE.deleteCampaignResponseFromCampaign(campaign);
        return deletedCampaignResponse;
    }

}
