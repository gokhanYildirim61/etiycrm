package com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateIndividualCustomerRequest {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String motherName;
    private String  fatherName;
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[0,2,4,6,8]{1}$")
    private String nationalityId;
    private LocalDate birthDate;

    //bu alanı ContactMediuma  çektik
    //@Pattern(regexp = "^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$")
   //private String email;
}


