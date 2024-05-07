package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;

import com.etiyacrm.customerservice.services.mapper.IndividualCustomerMapper;
import com.etiyacrm.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerService customerService;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerBusinessRules.individualCustomerNationalityIdMustBeUnique(createIndividualCustomerRequest.getNationalityId());
        individualCustomerBusinessRules.individualCustomerEmailMustBeUnique(createIndividualCustomerRequest.getEmail());

        Customer customer = customerService.addWithEmail(createIndividualCustomerRequest.getEmail());

        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualCreateCustomerRequest(createIndividualCustomerRequest);
        individualCustomer.setCustomer(customer);
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse response =  IndividualCustomerMapper.INSTANCE.createIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);
        response.setCustomerId(customer.getId());
        return response;
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {

        IndividualCustomer individualCustomer = individualCustomerRepository.findById(updateIndividualCustomerRequest.getId()).get();
        Customer customer = individualCustomer.getCustomer();

        System.out.println("customer id" + customer.getId());

        customer.setEmail(updateIndividualCustomerRequest.getEmail());
        individualCustomerBusinessRules.checkDeletedDate(individualCustomer.getDeletedDate());
        IndividualCustomer updatedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualUpdatedCustomerRequest(updateIndividualCustomerRequest);
        updatedIndividualCustomer.setCustomer(customer);

        System.out.println("updatecustomerid"+ updatedIndividualCustomer.getCustomer().getId());
        System.out.println("updatedid" + updatedIndividualCustomer.getId());

        // updatedIndividualCustomer.setUpdatedDate(LocalDateTime.now());
        updatedIndividualCustomer = individualCustomerRepository.save(updatedIndividualCustomer);
        System.out.println("updatecustomerid"+ updatedIndividualCustomer.getCustomer().getId());
        System.out.println("updatedid" + updatedIndividualCustomer.getId());

        return IndividualCustomerMapper.INSTANCE.updateIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);
    }

    @Override
    public GetIndividualCustomerResponse getById(long id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        individualCustomerBusinessRules.checkDeletedDate(individualCustomer.getDeletedDate());
        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerResponse(individualCustomer);
    }

    @Override
    public List<GetIndividualCustomerListResponse> getAll(PageInfo pageInfo) {

        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<IndividualCustomer> response = individualCustomerRepository.findAllByDeletedDateIsNull(pageable);
        List<GetIndividualCustomerListResponse> resultList = response.getContent().stream()
                .map(individualCustomer -> {
                    GetIndividualCustomerListResponse responseDto = IndividualCustomerMapper.INSTANCE.getIndividualCustomerListResponse(individualCustomer);
                     responseDto.setCustomerId(individualCustomer.getCustomer().getId());
                    return responseDto;
                })
                .collect(Collectors.toList());
        return resultList;
    }

/*public List<GetIndividualCustomerListResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<IndividualCustomer> response = individualCustomerRepository.findAll(pageable);
        response.map(individualCustomer -> IndividualCustomerMapper.INSTANCE.getIndividualCustomerListResponse(individualCustomer)).getContent();

    }*/


    @Override
    public DeletedIndividualCustomerResponse softDelete(long id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        individualCustomerBusinessRules.checkDeletedDate(individualCustomer.getDeletedDate());
        individualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomer);
        return IndividualCustomerMapper.INSTANCE.deleteIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }




}
