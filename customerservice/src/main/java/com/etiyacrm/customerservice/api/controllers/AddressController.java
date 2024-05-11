package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.adress.*;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/addresses")
public class AddressController {
    private AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add")
    public CreatedAddressResponse add(@Valid @RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.add(createAddressRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedAddressResponse update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest){
        return addressService.update(updateAddressRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetAddressResponse getByID(@PathVariable String id ){
        return addressService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetList")
    public GetListResponse<GetAllAddressResponse> getAllWithPaging(PageInfo pageInfo) {
        return addressService.getALLWithPaging(pageInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedAddressResponse delete(@PathVariable String id){
        return addressService.softDelete(id);
    }
}
