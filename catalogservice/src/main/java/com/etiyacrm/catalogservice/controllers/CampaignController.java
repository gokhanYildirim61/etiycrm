package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.CampaignService;
import com.etiyacrm.catalogservice.services.dtos.requests.campaign.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaign.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaign.*;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalogservice/api/v1/campaign")
@AllArgsConstructor
public class CampaignController {
    private CampaignService campaignService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedCampaignResponse add(@RequestBody CreateCampaignRequest createCampaignRequest){
        return campaignService.add(createCampaignRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedCampaignResponse updatedCampaignResponse(@RequestBody UpdateCampaignRequest updateCampaignRequest){
        return campaignService.update(updateCampaignRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetCampaignResponse getByID(@PathVariable String id ){
        return campaignService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetList")
    public GetListResponse<GetAllCampaignResponse> getAllWithPaging(PageInfo pageInfo) {
        return campaignService.getAllWithPaging(pageInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedCampaignResponse delete(@PathVariable String id){
        return  campaignService.softDelete(id);
    }

}
