package com.etiyacrm.catalogservice.services.dtos.responses.campaignProductOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCampaignProductOfferResponse {
    private String id;
    private String productOfferId;
    private String campaignId;
}
