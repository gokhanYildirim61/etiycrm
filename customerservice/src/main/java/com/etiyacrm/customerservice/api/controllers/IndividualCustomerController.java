package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.customerservice.business.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.customer.*;
import com.etiyacrm.customerservice.business.dtos.responses.individualCustomer.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/individualCustomers")
public class IndividualCustomerController {

    private IndividualCustomerService individualCustomerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest){
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
    public GetIndividualCustomerResponse getByID(@PathVariable long id ){
        return individualCustomerService.getById(id);
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetIndividualCustomerListResponse> getAll(){
        return individualCustomerService.getAll();
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedIndividualCustomerResponse delete(@PathVariable long id){
        return  individualCustomerService.softDelete(id);
    }


}
