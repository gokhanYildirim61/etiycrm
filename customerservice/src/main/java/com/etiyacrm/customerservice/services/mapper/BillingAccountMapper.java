package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.BillingAccount;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccount.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface BillingAccountMapper {


    BillingAccountMapper INSTANCE= Mappers.getMapper(BillingAccountMapper.class);

    @Mapping(source = "billingAccount.address.id", target = "addressId")
    @Mapping(source = "billingAccount.customer.id", target = "customerId")
    GetBillingAccountResponse getBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source = "billingAccount.address.id", target = "addressId")
    @Mapping(source = "billingAccount.customer.id", target = "customerId")
    GetAllBillingAccountResponse getAllBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "customerId", target = "customer.id")
    BillingAccount billingAccountFromCreateBillingAccountRequest(CreateBillingAccountRequest createBillingAccountRequest);
    @Mapping(source = "billingAccount.address.id", target = "addressId")
    @Mapping(source = "billingAccount.customer.id", target = "customerId")
    CreatedBillingAccountResponse createdBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);
    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "customerId", target = "customer.id")
    BillingAccount billingAccountFromUpdatedBillingAccountRequest(UpdateBillingAccountRequest updateBillingAccountRequest);
    @Mapping(source = "billingAccount.address.id", target = "addressId")
    @Mapping(source = "billingAccount.customer.id", target = "customerId")
    UpdatedBillingAccountResponse updatedBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    DeletedBillingAccountResponse deletedBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source = "content", target = "items")
    GetListResponse<GetAllBillingAccountResponse> pageInfoResponseFromPageBillingAccount(Page<BillingAccount> billingAccounts);

}
