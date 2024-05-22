package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.CustomerAccount;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.CreateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.UpdateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.customerAccount.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface CustomerAccountMapper {


    CustomerAccountMapper INSTANCE= Mappers.getMapper(CustomerAccountMapper.class);

    @Mapping(source = "customerAccount.address.id", target = "addressId")
    @Mapping(source = "customerAccount.customer.id", target = "customerId")
    GetCustomerAccountResponse getCustomerAccountResponseFromCustomerAccount(CustomerAccount customerAccount);

    @Mapping(source = "customerAccount.address.id", target = "addressId")
    @Mapping(source = "customerAccount.customer.id", target = "customerId")
    GetAllCustomerAccountResponse getAllCustomerAccountResponseFromCustomerAccount(CustomerAccount customerAccount);

    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "customerId", target = "customer.id")
    CustomerAccount customerAccountFromCreateCustomerAccountRequest(CreateCustomerAccountRequest createCustomerAccountRequest);
    @Mapping(source = "customerAccount.address.id", target = "addressId")
    @Mapping(source = "customerAccount.customer.id", target = "customerId")
    CreatedCustomerAccountResponse createdCustomerAccountResponseFromCustomerAccount(CustomerAccount customerAccount);
    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "customerId", target = "customer.id")
    CustomerAccount customerAccountFromUpdatedCustomerAccountRequest(UpdateCustomerAccountRequest updateCustomerAccountRequest);
    @Mapping(source = "customerAccount.address.id", target = "addressId")
    @Mapping(source = "customerAccount.customer.id", target = "customerId")
    UpdatedCustomerAccountResponse updatedCustomerAccountResponseFromCustomerAccount(CustomerAccount customerAccount);

    DeletedCustomerAccountResponse deletedCustomerAccountResponseFromCustomerAccount(CustomerAccount customerAccount);

    @Mapping(source = "content", target = "items")
    GetListResponse<GetAllCustomerAccountResponse> pageInfoResponseFromPageCustomerAccount(Page<CustomerAccount> customerAccounts);

}
