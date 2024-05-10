package com.etiyacrm.customerservice.services.mapper;

import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.adress.*;
import com.etiyacrm.customerservice.services.dtos.responses.city.GetAllCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    GetAddressResponse getAddressResponse(Address address);
    GetAllAddressResponse getAllAddressResponseFromAddress(Address address);
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);

    Address addressFromAddressUpdatedAddressRequest(UpdateAddressRequest updateAddressRequest);

    UpdatedAddressResponse updateAddressResponseFromAddress(Address address);

    DeletedAddressResponse deleteAddressResponseFromAddress(Address address);

    @Mapping(source = "pageAddress.content", target = "items")
    GetListResponse<GetAllAddressResponse> pageInfoResponseFromPageCity(Page<Address> pageAddress);


}
