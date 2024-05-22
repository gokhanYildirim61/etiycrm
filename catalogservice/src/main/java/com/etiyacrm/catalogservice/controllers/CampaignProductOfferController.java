package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.CampaignProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.CreateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.UpdateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignProductOffer.*;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("catalogservice/api/v1/campaignProductOffers")
public class CampaignProductOfferController {
    private CampaignProductOfferService campaignProductOfferService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCampaignProductOfferResponse add(@Valid @RequestBody CreateCampaignProductOfferRequest createCampaignProductOfferRequest) {
        return campaignProductOfferService.add(createCampaignProductOfferRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public GetListResponse<GetAllCampaignProductOfferResponse> getAllWithPaging(PageInfo  pageInfo) {
            return campaignProductOfferService.getAllWithPaging(pageInfo);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetCampaignProductOfferResponse getById(@PathVariable String id) {
        return campaignProductOfferService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCampaignProductOfferResponse update(@Valid @RequestBody UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest) {
        return campaignProductOfferService.update(updateCampaignProductOfferRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCampaignProductOfferResponse delete(@PathVariable String id) {
        return campaignProductOfferService.softDelete(id);
    }
}
