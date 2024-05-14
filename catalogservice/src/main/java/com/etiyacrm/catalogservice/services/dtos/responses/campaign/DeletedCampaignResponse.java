package com.etiyacrm.catalogservice.services.dtos.responses.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCampaignResponse {
    private String id;
    private LocalDateTime deletedDate;
}
