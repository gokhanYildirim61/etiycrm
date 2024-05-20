package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.*;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.GetIndividualCustomerListResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/contactMediums")
public class ContactMediumController {
    private ContactMediumService contactMediumService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetContactMediumListResponse> getAll(){
        return contactMediumService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedContactMediumResponse add(@Valid @RequestBody CreateContactMediumRequest createContactMediumRequest){
        return contactMediumService.add(createContactMediumRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdateContactMediumResponse update(@RequestBody UpdateContactMediumRequest updateContactMediumRequest){
        return contactMediumService.update(updateContactMediumRequest);
    }
    @GetMapping("/getByCustomerId/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByCustomerId")
    public GetContactMediumResponse getByCustomerId(@PathVariable String customerId){
        return contactMediumService.getByCustomerId(customerId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetContactMediumResponse getByID(@PathVariable String id ){
        return contactMediumService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedContactMediumResponse delete(@PathVariable String id){
        return  contactMediumService.softDelete(id);
    }
}
