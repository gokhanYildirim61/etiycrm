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
    @Size(min = 2,max = 50, message = "Individual Customer first name between 2 and 50 characters!")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Individual Customer last name is required!")
    @Size(min = 2,max = 50, message = "Individual Customer last name between 2 and 50 characters!")
    private String lastName;
    @NotBlank(message = "Individual Customer gender is required!")
    private String gender;
    private String motherName;
    private String  fatherName;
    @NotBlank(message = "Individual Customer Nationality ID is required!")
    @Size(min = 11,max = 11, message = "Individual Customer Nationality ID must have 11 characters!")
    private String nationalityId;
    @NotNull(message = "Individual Customer Birthdate is required!")
    private LocalDate birthDate;
}
