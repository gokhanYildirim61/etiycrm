package com.etiyacrm.customerservice.business.concretes;

import com.etiyacrm.customerservice.business.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.customer.GetCustomerListResponse;
import com.etiyacrm.customerservice.business.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.core.utilites.mapper.ModelMapperService;
import com.etiyacrm.customerservice.dataAccess.abstracts.IndividualCustomerRepository;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
        private IndividualCustomerRepository individualCustomerRepository;
        private ModelMapperService modelMapperService;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        IndividualCustomer individualCustomer=this.modelMapperService.forRequest().
                map(createIndividualCustomerRequest,IndividualCustomer.class);
        IndividualCustomer createdIndividualCustomer=this.individualCustomerRepository.save(individualCustomer);
        return this.modelMapperService.forResponse().
                    map(createdIndividualCustomer,CreatedIndividualCustomerResponse.class);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        IndividualCustomer existingIndividualCustomer=this.individualCustomerRepository.
                findById(updateIndividualCustomerRequest.getId()).get();
        IndividualCustomer updatedIndividualCustomer=this.modelMapperService.forRequest().
                map(updateIndividualCustomerRequest, IndividualCustomer.class);
        updatedIndividualCustomer.setCreatedDate(existingIndividualCustomer.getCreatedDate());
        updatedIndividualCustomer=this.individualCustomerRepository.save(existingIndividualCustomer);
        return this.modelMapperService.forResponse().
                map(updateIndividualCustomerRequest, UpdatedIndividualCustomerResponse.class);


    }

    @Override
    public GetIndividualCustomerResponse getById(long id) {
        IndividualCustomer individualCustomer=this.individualCustomerRepository.findById(id).get();
        return this.modelMapperService.forResponse().
                map(individualCustomer,GetIndividualCustomerResponse.class);
    }

    @Override
    public List<GetIndividualCustomerListResponse> getAll() {
        List<IndividualCustomer> individualCustomers=this.individualCustomerRepository.findAll();
        return individualCustomers.stream().filter(individualCustomer -> individualCustomer.getDeletedDate()==null).
                map(individualCustomer -> this.modelMapperService.forResponse().
                        map(individualCustomer, GetIndividualCustomerListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public DeletedIndividualCustomerResponse softDelete(long id) {
        IndividualCustomer existingIndividualCustomer=this.individualCustomerRepository.findById(id).get();
        existingIndividualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(existingIndividualCustomer);
        return  this.modelMapperService.forResponse().
                map(existingIndividualCustomer,DeletedIndividualCustomerResponse.class);
    }
}
