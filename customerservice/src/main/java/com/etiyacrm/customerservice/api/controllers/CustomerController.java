package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.customerservice.business.abstracts.CustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.customer.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
    private CustomerService customerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return  customerService.add(createCustomerRequest);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedCustomerResponse update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.update(updateCustomerRequest);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetCustomerResponse getByID(@PathVariable long id ){
        return customerService.getById(id);
    }





    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetCustomerListResponse> getAll(){
        return customerService.getAll();
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedCustomerResponse delete(@PathVariable long id){
         return  customerService.softDelete(id);
    }



}
