package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.CreateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.UpdateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignProductOffer.*;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;

public interface CampaignProductOfferService {
    CreatedCampaignProductOfferResponse add(CreateCampaignProductOfferRequest createCampaignProductOfferRequest);

    UpdatedCampaignProductOfferResponse update(UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest);

    GetCampaignProductOfferResponse getById(String  id);

    GetListResponse<GetAllCampaignProductOfferResponse> getAllWithPaging(PageInfo pageInfo);

    DeletedCampaignProductOfferResponse softDelete(String id);

}