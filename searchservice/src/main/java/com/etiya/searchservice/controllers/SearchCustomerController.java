package com.etiya.searchservice.controllers;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.service.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/searchCustomer")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;
@GetMapping("nationalityId")
    public Customer searchByNationalityId(@RequestParam String nationalityId){
        return filterService.searchByNationalityId(nationalityId);
    }
}
