package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.DeletedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.GetIndividualCustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("customerservice/api/v1/cities")
@AllArgsConstructor
public class CitiesController {
    private CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest) {
        return cityService.add(createCityRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update")
    public UpdatedCityResponse update(@Valid @RequestBody UpdateCityRequest updateCityRequest){
        return cityService.update(updateCityRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getByID")
    public GetCityResponse getByID(@PathVariable long id ){
        return cityService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetListResponse<GetAllCityResponse> getAllWithPaging(PageInfo pageInfo) {
        return cityService.getAllWithPaging(pageInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete")
    public DeletedCityResponse delete(@PathVariable long id){
        return  cityService.softDelete(id);
    }

}
