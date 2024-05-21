package com.etiyacrm.catalogservice.services.abstracts;


import com.etiyacrm.catalogservice.services.dtos.requests.campaign.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaign.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaign.*;
import com.etiyacrm.catalogservice.services.dtos.responses.product.*;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;

import java.util.List;

public interface CampaignService {

    CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest);
    UpdatedCampaignResponse update(UpdateCampaignRequest updateCampaignRequest);
    List<GetAllCampaignResponse> getAll();
    GetCampaignResponse getById(String id);
    DeletedCampaignResponse delete(String id);
}
