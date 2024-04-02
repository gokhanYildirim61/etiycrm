package com.etiyacrm.customerservice.business.concretes;

import com.etiyacrm.customerservice.business.abstracts.CustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.customer.*;
import com.etiyacrm.customerservice.core.utilites.mapper.ModelMapperService;
import com.etiyacrm.customerservice.dataAccess.abstracts.CustomerRepository;
import com.etiyacrm.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomerManager  implements CustomerService {

    private   CustomerRepository customerRepository ;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        Customer customer=this.modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        Customer createdCustomer=this.customerRepository.save(customer);

        return this.modelMapperService.forResponse().
                map(createdCustomer,CreatedCustomerResponse.class);


    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        Customer existingCustomer = this.customerRepository.findById(updateCustomerRequest.getId()).get();
        Customer updatedCustomer=this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        updatedCustomer.setCreatedDate(existingCustomer.getCreatedDate());
        updatedCustomer=this.customerRepository.save(updatedCustomer);
        return this.modelMapperService.forResponse().
                map(updatedCustomer,UpdatedCustomerResponse.class);

    }

    @Override
    public GetCustomerResponse getById(long id) {
        Customer customer=this.customerRepository.findById(id).get();
        return this.modelMapperService.forResponse()
                .map(customer,GetCustomerResponse.class);
    }

    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers=this.customerRepository.findAll();
        return customers.
                stream().filter(customer ->customer.getDeletedDate()==null).
                map(customer -> this.modelMapperService.forResponse().
                        map(customer,GetCustomerListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public DeletedCustomerResponse softDelete(long id) {
        Customer existingcustomer=this.customerRepository.findById(id).get();
        existingcustomer.setDeletedDate(LocalDateTime.now());
        customerRepository.save(existingcustomer);

        return this.modelMapperService.forResponse().
                map(existingcustomer,DeletedCustomerResponse.class);
    }
}
