package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.events.customers.CustomerCreatedEvent;
import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.kafka.producer.CustomerProducer;
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
    private CustomerProducer customerProducer;
//    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception {
        individualCustomerBusinessRules.individualCustomerNationalityIdMustBeUnique(createIndividualCustomerRequest.getNationalityId());
//        individualCustomerBusinessRules.individualCustomerEmailMustBeUnique(createIndividualCustomerRequest.getEmail());
        individualCustomerBusinessRules.checkIfNationalIdExists(
                createIndividualCustomerRequest.getNationalityId(),
                createIndividualCustomerRequest.getFirstName(), createIndividualCustomerRequest.getLastName(), createIndividualCustomerRequest.getBirthDate().getYear());


        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualCreateCustomerRequest(createIndividualCustomerRequest);
        individualCustomer.setCustomer(new Customer());
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse =  IndividualCustomerMapper.INSTANCE.createIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);
        createdIndividualCustomerResponse.setCustomerId(createdIndividualCustomer.getCustomer().getId());
        CustomerCreatedEvent customerCreatedEvent = IndividualCustomerMapper.INSTANCE.customerCreatedEventFromCreatedIndividualCustomerResponse(createdIndividualCustomerResponse);
        customerCreatedEvent.setCustomerId(createdIndividualCustomer.getCustomer().getId());
        customerProducer.sendMessage(customerCreatedEvent);
        System.out.println(customerCreatedEvent);

        return createdIndividualCustomerResponse;
    }

        //Page<IndividualCustomer> findByDeletedDateIsNull(Pageable pageable); kontrol için aldık
    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {

        IndividualCustomer individualCustomer = individualCustomerRepository.findById(updateIndividualCustomerRequest.getId()).get();
        Customer customer = individualCustomer.getCustomer();

        //bu alanı ContactMediuma çektik
        //customer.setEmail(updateIndividualCustomerRequest.getEmail());
        individualCustomerBusinessRules.checkDeletedDate(individualCustomer.getDeletedDate());
        IndividualCustomer updatedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualUpdatedCustomerRequest(updateIndividualCustomerRequest);
        updatedIndividualCustomer.setCustomer(customer);

         updatedIndividualCustomer.setUpdatedDate(LocalDateTime.now());
        updatedIndividualCustomer = individualCustomerRepository.save(updatedIndividualCustomer);
        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse=IndividualCustomerMapper.INSTANCE.
                updateIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);
        updatedIndividualCustomerResponse.setCustomerId(customer.getId());
        return updatedIndividualCustomerResponse;
    }

    @Override
    public GetIndividualCustomerResponse getById(String id) {
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
    public DeletedIndividualCustomerResponse softDelete(String id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        individualCustomerBusinessRules.checkDeletedDate(individualCustomer.getDeletedDate());
        individualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomer);
        return IndividualCustomerMapper.INSTANCE.deleteIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }




}
