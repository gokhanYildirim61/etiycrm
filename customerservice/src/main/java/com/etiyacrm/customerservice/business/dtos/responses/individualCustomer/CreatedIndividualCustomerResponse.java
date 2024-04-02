package com.etiyacrm.customerservice.business.dtos.responses.individualCustomer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedIndividualCustomerResponse {

    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String motherName;
    private String  fatherName;
    private String nationalityId;
    private LocalDate birthDate;
    private long customerId;
}
