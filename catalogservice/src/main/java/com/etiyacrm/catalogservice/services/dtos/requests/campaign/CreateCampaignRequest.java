package com.etiyacrm.catalogservice.services.dtos.requests.campaign;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCampaignRequest {
    private String name;
    private String description;
    private String code;
}
