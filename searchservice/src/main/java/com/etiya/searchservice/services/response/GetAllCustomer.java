package com.etiya.searchservice.services.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomer {

    private String customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nationalityId;


}
