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
    @NotBlank(message = "Individual Customer first name is required!")
    @Size(min = 2,max = 30)
    private String firstName;
    private String middleName;
    @NotBlank(message = "Individual Customer last name is required!")
    private String lastName;
    @NotBlank(message = "Individual Customer gender is required!")
    private String gender;
    private String motherName;
    private String  fatherName;
    @NotBlank(message = "Individual Customer Nationality ID is required!")
    private String nationalityId;
    @NotNull(message = "Individual Customer Birthdate is required!")
    private LocalDate birthDate;



}
