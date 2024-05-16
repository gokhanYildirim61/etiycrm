package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.abstracts.BillingAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccount.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/billingAccounts")
public class BillingAccountController {
    BillingAccountService billingAccountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedBillingAccountResponse add(@Valid @RequestBody CreateBillingAccountRequest createBillingAccountRequest) {
        return billingAccountService.add(createBillingAccountRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedBillingAccountResponse update(@Valid @RequestBody UpdateBillingAccountRequest updateBillingAccountRequest){
        return billingAccountService.update(updateBillingAccountRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetBillingAccountResponse getByID(@PathVariable String id ){
        return billingAccountService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetList")
    public GetListResponse<GetAllBillingAccountResponse> getAllWithPaging(PageInfo pageInfo) {
        return billingAccountService.getAllWithPaging(pageInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedBillingAccountResponse delete(@PathVariable String id){
        return billingAccountService.softDelete(id);
    }
}

