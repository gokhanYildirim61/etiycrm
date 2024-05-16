package com.etiyacrm.customerservice.services.dtos.responses.billingAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedBillingAccountResponse {
    private String id;
    private boolean status;
    private String number;
    private String name;
    private String description;
    private String type;
    private String customerId;
    private String addressId;
}
