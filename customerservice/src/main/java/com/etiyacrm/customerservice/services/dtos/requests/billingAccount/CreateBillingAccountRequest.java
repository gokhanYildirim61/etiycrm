package com.etiyacrm.customerservice.services.dtos.requests.billingAccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBillingAccountRequest {
    @NotNull(message = "Account Status is required!")
    private boolean status;
    @NotBlank(message = "Account Number is required!")
    private String number;
    @NotBlank(message = "Account Name is required!")
    private String name; //+
//    private String description; // Adres tablosundaki description sütunu zaten buraya verilecek. Input olarak almaya gerek yok.
    @NotBlank(message = "Account Type is required!")
    private String type;
    @NotBlank(message = "Customer ID is required!")
    private String customerId;
    @NotBlank(message = "Address ID is required!")
    private String addressId; //+
}
