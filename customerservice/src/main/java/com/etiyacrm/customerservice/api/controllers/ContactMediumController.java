package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.UpdateContactMediumResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/contactMediums")
public class ContactMediumController {
    private ContactMediumService contactMediumService;

    @PostMapping
    @ResponseStatus
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetContactMediumResponse getByID(@PathVariable String id ){
        return contactMediumService.getById(id);
    }
}
