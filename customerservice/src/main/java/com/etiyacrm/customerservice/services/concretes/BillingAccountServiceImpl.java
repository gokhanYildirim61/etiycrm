package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.BillingAccount;
import com.etiyacrm.customerservice.repositories.BillingAccountRepository;
import com.etiyacrm.customerservice.services.abstracts.BillingAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccount.*;
import com.etiyacrm.customerservice.services.mapper.BillingAccountMapper;
import com.etiyacrm.customerservice.services.rules.BillingAccountBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BillingAccountServiceImpl implements BillingAccountService {
    private BillingAccountRepository billingAccountRepository;
    private BillingAccountBusinessRules billingAccountBusinessRules;

    @Override
    public CreatedBillingAccountResponse add(CreateBillingAccountRequest createBillingAccountRequest) {
        BillingAccount  billingAccount = BillingAccountMapper.INSTANCE.billingAccountFromCreateBillingAccountRequest(createBillingAccountRequest);
        BillingAccount createBillingAccount=billingAccountRepository.save(billingAccount);
        CreatedBillingAccountResponse createdBillingAccountResponse=BillingAccountMapper.INSTANCE.createdBillingAccountResponseFromBillingAccount(createBillingAccount);
        return createdBillingAccountResponse;
    }

    @Override
    public UpdatedBillingAccountResponse update(UpdateBillingAccountRequest updateBillingAccountRequest) {
        BillingAccount billingAccount= BillingAccountMapper.INSTANCE.billingAccountFromUpdatedBillingAccountRequest(updateBillingAccountRequest);
        billingAccountBusinessRules.checkDeletedDate(billingAccount.getDeletedDate());
        BillingAccount updateBillingAccount=billingAccountRepository.save(billingAccount);
        UpdatedBillingAccountResponse response =BillingAccountMapper.INSTANCE.updatedBillingAccountResponseFromBillingAccount(updateBillingAccount);
        return  response;
    }

    @Override
    public GetBillingAccountResponse getById(String id) {
        BillingAccount billingAccount= billingAccountRepository.findById(id).get();
        billingAccountBusinessRules.checkDeletedDate(billingAccount.getDeletedDate());
        GetBillingAccountResponse response=BillingAccountMapper.INSTANCE.getBillingAccountResponseFromBillingAccount(billingAccount);
        return  response;
    }

    @Override
    public GetListResponse<GetAllBillingAccountResponse> getAllWithPaging(PageInfo pageInfo) {
        Pageable pageable= PageRequest.of(pageInfo.getPage(),pageInfo.getSize());
        Page<BillingAccount> response=billingAccountRepository.findAll(pageable);
        GetListResponse<GetAllBillingAccountResponse> responses=BillingAccountMapper.INSTANCE.pageInfoResponseFromPageBillingAccount(response);
        responses.setHasNext(response.hasNext());
        responses.setHasPrevious(response.hasPrevious());
        responses.setPage(pageInfo.getPage());
        return responses;
    }


    @Override
    public DeletedBillingAccountResponse softDelete(String id) {
        BillingAccount billingAccount=billingAccountRepository.findById(id).get();
        billingAccountBusinessRules.checkDeletedDate(billingAccount.getDeletedDate());
        billingAccount.setDeletedDate(LocalDateTime.now());
        billingAccountRepository.save(billingAccount);
        DeletedBillingAccountResponse deletedBillingAccountResponse=BillingAccountMapper.INSTANCE.deletedBillingAccountResponseFromBillingAccount(billingAccount);
        return deletedBillingAccountResponse;
    }
}
