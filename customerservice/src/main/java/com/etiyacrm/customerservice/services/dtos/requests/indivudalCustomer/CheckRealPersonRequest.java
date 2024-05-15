package com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckRealPersonRequest {
    @NotBlank(message = "Firstname is required!")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Lastname is required!")
    private String lastName;
    @NotBlank(message = "Nationality ID is required!")
    private String nationalityId;
    @NotNull(message = "Birth year is required!")
    private int birthYear;
}
