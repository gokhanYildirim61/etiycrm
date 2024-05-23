package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.events.customers.CustomerCreatedEvent;
import com.etiyacrm.common.events.customers.CustomerDeletedEvent;
import com.etiyacrm.common.events.customers.CustomerUpdatedEvent;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.kafka.producer.CustomerProducer;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CheckRealPersonRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.services.mapper.IndividualCustomerMapper;
import com.etiyacrm.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
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
        individualCustomerBusinessRules.checkIndividualCustomerAge(createIndividualCustomerRequest.getBirthDate());
//        TODO: Sürekli gerçek data kullanmamak için yorum satırına alındı.
//        TODO: Gerçek data ile çalışmak için yorum satırını kaldırınız.
//        individualCustomerBusinessRules.checkIfNationalIdExists(
//                createIndividualCustomerRequest.getNationalityId(),
//                createIndividualCustomerRequest.getFirstName(), createIndividualCustomerRequest.getMiddleName(), createIndividualCustomerRequest.getLastName(), createIndividualCustomerRequest.getBirthDate().getYear());
        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualCreateCustomerRequest(createIndividualCustomerRequest);
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse =  IndividualCustomerMapper.INSTANCE.createIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);

        CustomerCreatedEvent customerCreatedEvent = IndividualCustomerMapper.INSTANCE.customerCreatedEventFromCreatedIndividualCustomerResponse(createdIndividualCustomerResponse);
        customerProducer.sendMessage(customerCreatedEvent);
        return createdIndividualCustomerResponse;
    }


    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) throws Exception {
        //IndividualCustomer individualCustomer = individualCustomerRepository.findById(updateIndividualCustomerRequest.getId()).get();
        individualCustomerBusinessRules.checkIfIndividualCustomerExists(updateIndividualCustomerRequest.getId());
        Customer customer = customerService.getById(updateIndividualCustomerRequest.getId());
        individualCustomerBusinessRules.checkDeletedDate(customer.getDeletedDate());
        individualCustomerBusinessRules.checkIndividualCustomerAge(updateIndividualCustomerRequest.getBirthDate());
//                TODO: Sürekli gerçek data kullanmamak için yorum satırına alındı.
//                TODO: Gerçek data ile çalışmak için yorum satırını kaldırınız.
//                individualCustomerBusinessRules.checkIfNationalIdExists(
//                        updateIndividualCustomerRequest.getNationalityId(),
//                        updateIndividualCustomerRequest.getFirstName(), updateIndividualCustomerRequest.getMiddleName(), updateIndividualCustomerRequest.getLastName(), updateIndividualCustomerRequest.getBirthDate().getYear());
        IndividualCustomer updatedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromIndividualUpdatedCustomerRequest(updateIndividualCustomerRequest);
        updatedIndividualCustomer.setUpdatedDate(LocalDateTime.now());
        updatedIndividualCustomer = individualCustomerRepository.save(updatedIndividualCustomer);
        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse=IndividualCustomerMapper.INSTANCE.updateIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);
        CustomerUpdatedEvent customerUpdatedEvent = IndividualCustomerMapper.INSTANCE.customerUpdatedEventFromUpdatedIndividualCustomerResponse(updatedIndividualCustomerResponse);
        customerProducer.sendMessage(customerUpdatedEvent);

        return updatedIndividualCustomerResponse;
    }

    @Override
    public GetIndividualCustomerResponse getById(String id) {
        Customer customer = customerService.getById(id);
        individualCustomerBusinessRules.checkDeletedDate(customer.getDeletedDate());
        individualCustomerBusinessRules.checkIfIndividualCustomerExists(customer.getId());
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerResponse(individualCustomer);
    }

    @Override
    public List<GetIndividualCustomerListResponse> getAll() {
        List<IndividualCustomer> individualCustomerList = individualCustomerRepository.findAll();
        return individualCustomerList.stream().map(IndividualCustomerMapper.INSTANCE::getIndividualCustomerListResponse).collect(Collectors.toList());
    }

    @Override
    public boolean checkIfNationalityIdExists(String nationalityId) {
        return individualCustomerRepository.existsByNationalityId(nationalityId);
    }

    @Override
    public boolean checkIfRealPerson(CheckRealPersonRequest checkRealPersonRequest) throws Exception {
        return individualCustomerBusinessRules.checkIfRealPerson(checkRealPersonRequest);
    }


    @Override
    public DeletedIndividualCustomerResponse softDelete(String id) {
        Customer customer = customerService.getById(id);
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        individualCustomerBusinessRules.checkDeletedDate(customer.getDeletedDate());
        customer.setDeletedDate(LocalDateTime.now());
        customer = customerService.setDeletedDate(customer);
//        CustomerUpdatedEvent customerUpdatedEvent = IndividualCustomerMapper.INSTANCE.customerUpdatedEventFromIndividualCustomer(individualCustomer);
//        customerUpdatedEvent.setId(customer.getId());
//        customerUpdatedEvent.setDeletedDate(customer.getDeletedDate());
        CustomerDeletedEvent customerDeletedEvent = new CustomerDeletedEvent();
        customerDeletedEvent.setId(customer.getId());
        customerDeletedEvent.setDeletedDate(customer.getDeletedDate());

        customerProducer.sendMessage(customerDeletedEvent);
        return IndividualCustomerMapper.INSTANCE.deleteCustomerResponseFromCustomer(customer);
    }
}