package com.etiyacrm.customerservice.services.dtos.requests.billingAccount;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBillingAccountRequest {
    private String id;
    private boolean status;
    private String accountNumber;
    private String name;
    private String description;
    private String type;
    private String customerId;
    private String addressId;
}
