package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.events.customers.CustomerCreatedEvent;
import com.etiyacrm.common.events.customers.CustomerUpdatedEvent;
import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.kafka.producer.CustomerProducer;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
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

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception {
        individualCustomerBusinessRules.individualCustomerNationalityIdMustBeUnique(createIndividualCustomerRequest.getNationalityId());

//        TODO: Sürekli gerçek data kullanmamak için yorum satırına alındı.
//        TODO: Gerçek data ile çalışmak için yorum satırını kaldırınız.
//        individualCustomerBusinessRules.checkIfNationalIdExists(
//                createIndividualCustomerRequest.getNationalityId(),
//                createIndividualCustomerRequest.getFirstName(), createIndividualCustomerRequest.getLastName(), createIndividualCustomerRequest.getBirthDate().getYear());


        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualCreateCustomerRequest(createIndividualCustomerRequest);

        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse =  IndividualCustomerMapper.INSTANCE.createIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);

        CustomerCreatedEvent customerCreatedEvent = IndividualCustomerMapper.INSTANCE.customerCreatedEventFromCreatedIndividualCustomerResponse(createdIndividualCustomerResponse);

        customerProducer.sendMessage(customerCreatedEvent);
        System.out.println(customerCreatedEvent);

        return createdIndividualCustomerResponse;
    }

        //Page<IndividualCustomer> findByDeletedDateIsNull(Pageable pageable); kontrol için aldık
    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {

        IndividualCustomer individualCustomer = individualCustomerRepository.findById(updateIndividualCustomerRequest.getId()).get();
        Customer customer = customerService.getById(updateIndividualCustomerRequest.getId());

        individualCustomerBusinessRules.checkDeletedDate(customer.getDeletedDate());
        IndividualCustomer updatedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualUpdatedCustomerRequest(updateIndividualCustomerRequest);

        updatedIndividualCustomer.setUpdatedDate(LocalDateTime.now());
        updatedIndividualCustomer = individualCustomerRepository.save(updatedIndividualCustomer);
        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse=IndividualCustomerMapper.INSTANCE.
                updateIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);

        CustomerUpdatedEvent customerUpdatedEvent = IndividualCustomerMapper.INSTANCE.customerUpdatedEventFromUpdatedIndividualCustomerResponse(updatedIndividualCustomerResponse);

        customerProducer.sendMessage(customerUpdatedEvent);
        System.out.println(customerUpdatedEvent);

        return updatedIndividualCustomerResponse;
    }

    @Override
    public GetIndividualCustomerResponse getById(String id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        Customer customer = customerService.getById(id);
        individualCustomerBusinessRules.checkDeletedDate(customer.getDeletedDate());
        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerResponse(individualCustomer);
    }

    @Override
    public List<GetIndividualCustomerListResponse> getAll(PageInfo pageInfo) {

        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<IndividualCustomer> response = individualCustomerRepository.findAllByDeletedDateIsNull(pageable);
        List<GetIndividualCustomerListResponse> resultList = response.getContent().stream()
                .map(individualCustomer -> {
                    GetIndividualCustomerListResponse responseDto = IndividualCustomerMapper.INSTANCE.getIndividualCustomerListResponse(individualCustomer);

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
        Customer customer = customerService.getById(id);
        individualCustomerBusinessRules.checkDeletedDate(customer.getDeletedDate());
        customer.setDeletedDate(LocalDateTime.now());
        customer = customerService.setDeletedDate(customer);
        return IndividualCustomerMapper.INSTANCE.deleteCustomerResponseFromCustomer(customer);
    }




}
