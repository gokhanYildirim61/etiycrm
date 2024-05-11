package com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerRequest {
    @NotBlank(message = "IndividualCustomer name cannot be empty")
    @Size(min = 2,max = 30)
    private String firstName;
    private String middleName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String gender;
    private String motherName;
    private String  fatherName;
    @NotBlank
    private String nationalityId;
    @NotNull
    private LocalDate birthDate;



}
