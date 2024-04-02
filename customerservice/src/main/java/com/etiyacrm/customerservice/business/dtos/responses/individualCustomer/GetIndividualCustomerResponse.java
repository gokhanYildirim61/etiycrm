package com.etiyacrm.customerservice.business.dtos.responses.individualCustomer;

import com.etiyacrm.customerservice.entities.Customer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetIndividualCustomerResponse {
    private long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String motherName;
    private String  fatherName;
    private String nationalityId;
    private LocalDate birthDate;
}
