package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.CampaignProductOffer;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.CreateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.UpdateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignProductOffer.*;
import com.etiyacrm.common.business.responses.GetListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface CampaignProductOfferMapper {
    CampaignProductOfferMapper INSTANCE = Mappers.getMapper(CampaignProductOfferMapper.class);
    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "campaign.name", target = "campaignName")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    @Mapping(source = "productOffer.name", target = "productOfferName")
    @Mapping(source = "productOffer.price", target = "productOfferPrice")
    GetAllCampaignProductOfferResponse getAllCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaignId", target = "campaign.id")
    @Mapping(source = "productOfferId", target = "productOffer.id")
    CampaignProductOffer campaignProductOfferFromCreateCampaignProductOfferRequest(CreateCampaignProductOfferRequest createCampaignProductOfferRequest);
    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "campaign.name", target = "campaignName")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    @Mapping(source = "productOffer.name", target = "productOfferName")
    @Mapping(source = "productOffer.price", target = "productOfferPrice")
    CreatedCampaignProductOfferResponse createdCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaignId", target = "campaign.id")
    @Mapping(source = "productOfferId", target = "productOffer.id")
    CampaignProductOffer campaignProductOfferFromUpdateCampaignProductOfferRequest(UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest);
    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    UpdatedCampaignProductOfferResponse updatedCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    DeletedCampaignProductOfferResponse deletedCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "campaign.name", target = "campaignName")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    @Mapping(source = "productOffer.name", target = "productOfferName")
    @Mapping(source = "productOffer.price", target = "productOfferPrice")
    GetCampaignProductOfferResponse getCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "pageCampaignProductOffer.content", target = "items")
    GetListResponse<GetAllCampaignProductOfferResponse> pageInfoResponseFromPageCampaignProductOffer(Page<CampaignProductOffer> pageCampaignProductOffer);
}
