package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/individualCustomers")
public class IndividualCustomerController {

    private IndividualCustomerService individualCustomerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception {
        return  individualCustomerService.add(createIndividualCustomerRequest);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedIndividualCustomerResponse update(@Valid @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest){
        return individualCustomerService.update(updateIndividualCustomerRequest);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetIndividualCustomerResponse getByID(@PathVariable String id ){
        return individualCustomerService.getById(id);
    }



   @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
        public List<GetIndividualCustomerListResponse> getAll(PageInfo pageInfo){
        return individualCustomerService.getAll(pageInfo);
   }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedIndividualCustomerResponse delete(@PathVariable String id){
        return  individualCustomerService.softDelete(id);
    }

    /*@GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetList")
    public GetListResponse<GetIndividualCustomerListResponse> getAllWithPaging(PageInfo pageInfo) {
        return individualCustomerService.getAllWithPaging(pageInfo);
    }*/


}
