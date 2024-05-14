package com.etiyacrm.catalogservice.services.dtos.requests.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCampaignRequest {
    private String id;
    private String name;
    private String description;
    private String code;

}
