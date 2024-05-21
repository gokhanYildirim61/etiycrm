package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.Campaign;
import com.etiyacrm.catalogservice.services.dtos.requests.campaign.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaign.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaign.*;
import com.etiyacrm.common.business.responses.GetListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface CampaignMapper {
    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);

    //TODO:MAPPERLAR DÜZELİTECEK SERVİCE VE CONTROLLER DÜZELTİLECEK YENİ EKLENEN ENTİTİYLER İÇİN BUNLAR YAZILACAK.

//    GetCampaignResponse getCampaignResponse(Campaign campaign);
//
//    GetAllCampaignResponse getAllCampaignResponseFromCampaign(Campaign campaign);
//
//    Campaign campaignFromCreateCampaignRequest(CreateCampaignRequest createCampaignRequest);
//
//    CreatedCampaignResponse createdCampaignResponseFromCampaign(Campaign campaign);
//
//    Campaign campaignFromCampaignUpdatedCampaignRequest(UpdateCampaignRequest updateCampaignRequest);
//
//    UpdatedCampaignResponse updateCampaignResponseFromCampaign(Campaign campaign);
//
//    DeletedCampaignResponse deleteCampaignResponseFromCampaign(Campaign campaign);
//
//    @Mapping(source = "pageCampaign.content", target = "items")
//    GetListResponse<GetAllCampaignResponse> pageInfoResponseFromPageCampaign(Page<Campaign> pageCampaign);

}
