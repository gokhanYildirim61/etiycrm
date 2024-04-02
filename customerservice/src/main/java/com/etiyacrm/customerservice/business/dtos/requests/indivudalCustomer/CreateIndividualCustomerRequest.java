package com.etiyacrm.customerservice.business.dtos.requests.indivudalCustomer;


import com.etiyacrm.customerservice.entities.Customer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @NotNull
    private long customerId;
}
