package com.etiyacrm.common.events.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdatedEvent {
    private String id;
    private String customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private String gender;
    private String nationalityId;
    private LocalDate birthDate;
}
