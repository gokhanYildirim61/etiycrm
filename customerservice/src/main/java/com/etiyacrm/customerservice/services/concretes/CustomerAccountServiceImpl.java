package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.CustomerAccount;
import com.etiyacrm.customerservice.repositories.CustomerAccountRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.CreateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.customerAccount.UpdateCustomerAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.customerAccount.*;
import com.etiyacrm.customerservice.services.mapper.CustomerAccountMapper;
import com.etiyacrm.customerservice.services.rules.CustomerAccountBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {
    private CustomerAccountRepository customerAccountRepository;
    private CustomerAccountBusinessRules customerAccountBusinessRules;

    @Override
    public CreatedCustomerAccountResponse add(CreateCustomerAccountRequest createCustomerAccountRequest) {
        CustomerAccount customerAccount = CustomerAccountMapper.INSTANCE.customerAccountFromCreateCustomerAccountRequest(createCustomerAccountRequest);
        CustomerAccount createCustomerAccount = customerAccountRepository.save(customerAccount);
        CreatedCustomerAccountResponse createdCustomerAccountResponse = CustomerAccountMapper.INSTANCE.createdCustomerAccountResponseFromCustomerAccount(createCustomerAccount);
        return createdCustomerAccountResponse;
    }

    @Override
    public UpdatedCustomerAccountResponse update(UpdateCustomerAccountRequest updateCustomerAccountRequest) {
        CustomerAccount customerAccount = CustomerAccountMapper.INSTANCE.customerAccountFromUpdatedCustomerAccountRequest(updateCustomerAccountRequest);
        customerAccountBusinessRules.checkDeletedDate(customerAccount.getDeletedDate());
        CustomerAccount updateCustomerAccount = customerAccountRepository.save(customerAccount);
        UpdatedCustomerAccountResponse response = CustomerAccountMapper.INSTANCE.updatedCustomerAccountResponseFromCustomerAccount(updateCustomerAccount);
        return  response;
    }

    @Override
    public GetCustomerAccountResponse getById(String id) {
        Optional<CustomerAccount> customerAccountOptional = customerAccountRepository.findById(id);
        customerAccountBusinessRules.checkCustomerAccount(customerAccountOptional);
        CustomerAccount customerAccount = customerAccountOptional.get();
        customerAccountBusinessRules.checkDeletedDate(customerAccount.getDeletedDate());
        GetCustomerAccountResponse response = CustomerAccountMapper.INSTANCE.getCustomerAccountResponseFromCustomerAccount(customerAccount);
        return  response;
    }

    @Override
    public GetListResponse<GetAllCustomerAccountResponse> getAllWithPaging(PageInfo pageInfo) {
        Pageable pageable= PageRequest.of(pageInfo.getPage(),pageInfo.getSize());
        Page<CustomerAccount> response= customerAccountRepository.findAll(pageable);
        GetListResponse<GetAllCustomerAccountResponse> responses= CustomerAccountMapper.INSTANCE.pageInfoResponseFromPageCustomerAccount(response);
        responses.setHasNext(response.hasNext());
        responses.setHasPrevious(response.hasPrevious());
        responses.setPage(pageInfo.getPage());
        return responses;
    }


    @Override
    public DeletedCustomerAccountResponse softDelete(String id) {
        Optional<CustomerAccount> customerAccountOptional = customerAccountRepository.findById(id);
        customerAccountBusinessRules.checkCustomerAccount(customerAccountOptional);
        CustomerAccount customerAccount = customerAccountOptional.get();
        customerAccountBusinessRules.checkDeletedDate(customerAccount.getDeletedDate());
        customerAccount.setDeletedDate(LocalDateTime.now());
        customerAccountRepository.save(customerAccount);
        DeletedCustomerAccountResponse deletedCustomerAccountResponse = CustomerAccountMapper.INSTANCE.deletedCustomerAccountResponseFromCustomerAccount(customerAccount);
        return deletedCustomerAccountResponse;
    }
}
