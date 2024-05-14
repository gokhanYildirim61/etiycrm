package com.etiya.searchservice.controllers;

import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiya.searchservice.services.response.GetAllCustomer;
import com.etiyacrm.common.utilities.results.PageableResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("searchservice/api/v1/searchCustomers")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;
@GetMapping("/params")
    public ResponseEntity<?> search(
        @RequestParam(required = false) String nationalityId,
        @RequestParam(required = false) String customerId,
        @RequestParam(required = false) String accountId,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String middleName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String orderId,
        @PageableDefault(size = 10, sort = "firstName") Pageable pageable){
    PageableResponse<GetAllCustomer> result = filterService.search(
            nationalityId, customerId, accountId, firstName, middleName, lastName, orderId, pageable);
            if (result.getTotalElements()>0){
                return ResponseEntity.ok(result);
            }
            return ResponseEntity.notFound().build();
    }
}
