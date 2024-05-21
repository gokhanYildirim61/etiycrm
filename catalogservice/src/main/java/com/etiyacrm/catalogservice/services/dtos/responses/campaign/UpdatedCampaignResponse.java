package com.etiyacrm.catalogservice.services.dtos.responses.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCampaignResponse {
    private String id;
    private String name;
    private String description;
    private String code;
    private int discount;
}
