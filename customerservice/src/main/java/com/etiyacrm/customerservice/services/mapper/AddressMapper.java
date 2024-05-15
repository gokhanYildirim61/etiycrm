package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.adress.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


    @Mapping(source = "address.city.id", target = "cityId")
    @Mapping(source = "address.customer.id", target = "customerId")
    GetAddressResponse getAddressResponse(Address address);

    @Mapping(source = "address.city.id", target = "cityId")
    @Mapping(source = "address.customer.id", target = "customerId")
    GetAllAddressResponse getAllAddressResponseFromAddress(Address address);

    @Mapping(source = "cityId" , target = "city.id")
    @Mapping(source = "customerId" , target = "customer.id")
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);

    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);

    @Mapping(source = "cityId" , target = "city.id")
    @Mapping(source = "customerId" , target = "customer.id")
    Address addressFromAddressUpdatedAddressRequest(UpdateAddressRequest updateAddressRequest);

    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    UpdatedAddressResponse updateAddressResponseFromAddress(Address address);

    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    DeletedAddressResponse deleteAddressResponseFromAddress(Address address);

    @Mapping(source = "pageAddress.content", target = "items")
    GetListResponse<GetAllAddressResponse> pageInfoResponseFromPageCity(Page<Address> pageAddress);


}
