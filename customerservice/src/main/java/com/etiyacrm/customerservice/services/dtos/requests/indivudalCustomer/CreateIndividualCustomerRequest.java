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
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[0,2,4,6,8]{1}$")
    private String nationalityId;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$")
    private String email;
//    @NotNull
//    private long customerId;
}
