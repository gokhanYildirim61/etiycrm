package com.etiyacrm.catalogservice.services.dtos.requests.campaign;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCampaignRequest {
    @NotBlank(message = "Campaign id is required to update")
    private String id;

    @NotBlank(message = "Campaign name cannot be empty")
    private String name;

    @NotBlank(message = "Campaign description cannot be empty")
    private String description;

    @NotBlank(message = "Campaign code cannot be empty")
    private String code;
    private int discount;

}
