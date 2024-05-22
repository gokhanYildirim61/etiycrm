package com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCampaignProductOfferRequest {

    private String productOfferId;
    private String campaignId;
}
