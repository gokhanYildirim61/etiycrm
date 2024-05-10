package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.adress.CreatedAddressResponse;
import com.etiyacrm.customerservice.services.dtos.responses.adress.GetAllAddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    GetAllAddressResponse getAllAddressResponseFromAddress(Address address);
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);

}
