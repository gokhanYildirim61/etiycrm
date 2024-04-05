package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.indivudalCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface IndividualCustomerMapper {
    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);
    GetIndividualCustomerResponse getIndividualCustomerResponse(IndividualCustomer individualCustomer);
    GetIndividualCustomerListResponse getIndividualCustomerListResponse(IndividualCustomer individualCustomer);
    IndividualCustomer individualCustomerFromIndividualCreateCustomerRequest(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    CreatedIndividualCustomerResponse createIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);
    IndividualCustomer individualCustomerFromIndividualUpdatedCustomerRequest(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    UpdatedIndividualCustomerResponse updateIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);
    DeletedIndividualCustomerResponse deleteIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);
    @Mapping(source = "pageIndividualCustomer.content", target = "items")
    GetListResponse<GetIndividualCustomerListResponse> pageInfoResponseFromPageIndividualResponseIndividualCustomer(Page<IndividualCustomer> pageIndividualCustomer);


}
