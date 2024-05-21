package com.etiyacrm.catalogservice.services.dtos.requests.campaign;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCampaignRequest {
    @NotBlank(message = "Campaign name cannot be empty")
    private String name;

    @NotBlank(message = "Campaign description cannot be empty")
    private String description;

    @NotBlank(message = "Campaign code cannot be empty")
    private String code;

    private int discount;
}
