package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.abstracts.CustomerAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.CreateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.UpdateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.customerAccount.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/customerAccounts")
public class CustomerAccountController {
    CustomerAccountService customerAccountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedCustomerAccountResponse add(@Valid @RequestBody CreateCustomerAccountRequest createCustomerAccountRequest) {
        return customerAccountService.add(createCustomerAccountRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedCustomerAccountResponse update(@Valid @RequestBody UpdateCustomerAccountRequest updateCustomerAccountRequest){
        return customerAccountService.update(updateCustomerAccountRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetCustomerAccountResponse getByID(@PathVariable String id ){
        return customerAccountService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetList")
    public GetListResponse<GetAllCustomerAccountResponse> getAllWithPaging(PageInfo pageInfo) {
        return customerAccountService.getAllWithPaging(pageInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedCustomerAccountResponse delete(@PathVariable String id){
        return customerAccountService.softDelete(id);
    }
}

