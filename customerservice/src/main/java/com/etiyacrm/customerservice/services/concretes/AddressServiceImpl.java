package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.adress.*;
import com.etiyacrm.customerservice.services.mapper.AddressMapper;
import com.etiyacrm.customerservice.services.rules.AddressBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressBusinessRules addressBusinessRules;
    private CityService cityService;
    private CustomerService customerService;

    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        Address address= AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);
        Address createdAddress= addressRepository.save(address);
        Customer customer=customerService.getById(createAddressRequest.getCustomerId());
         createdAddress.setCustomer(customer);

        City city=cityService.getById2(createAddressRequest.getCityId());
        createdAddress.setCity(city);
        addressRepository.save(createdAddress);
        CreatedAddressResponse createdAddressResponse=AddressMapper.INSTANCE.createdAddressResponseFromAddress(createdAddress);
        createdAddressResponse.setCustomerId(createdAddress.getCustomer().getId());
        createdAddressResponse.setCityId(createdAddress.getCity().getId());
        return createdAddressResponse;

    }

    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        Address address = addressRepository.findById(updateAddressRequest.getId()).get();
        Address updatedAddress= AddressMapper.INSTANCE.addressFromAddressUpdatedAddressRequest(updateAddressRequest);
        updatedAddress.setCustomer(address.getCustomer());
        updatedAddress= addressRepository.save(updatedAddress);
        UpdatedAddressResponse updatedAddressResponse=AddressMapper.INSTANCE.updateAddressResponseFromAddress(updatedAddress);
        updatedAddressResponse.setCustomerId(updatedAddress.getCustomer().getId());
        updatedAddressResponse.setCityId(updatedAddress.getCity().getId());
        return updatedAddressResponse;

    }

    @Override
    public GetAddressResponse getById(String id) {
        Address address=addressRepository.findById(id).get();
        GetAddressResponse getAddressResponse=AddressMapper.INSTANCE.getAddressResponse(address);
        getAddressResponse.setCityId(address.getCity().getId());
        getAddressResponse.setCustomerId(address.getCustomer().getId());
        return getAddressResponse;
    }

    @Override
    public GetListResponse<GetAllAddressResponse> getALLWithPaging(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Address> response =addressRepository.findAllByDeletedDateIsNull(pageable);

        GetListResponse<GetAllAddressResponse> responses = AddressMapper.INSTANCE.pageInfoResponseFromPageCity(response);
        responses.setHasNext(response.hasNext());
        responses.setHasPrevious(response.hasPrevious());
        responses.setPage(pageInfo.getPage());
        return responses;
    }

    @Override
    public DeletedAddressResponse softDelete(String id) {
        Address address=addressRepository.findById(id).get();
        addressBusinessRules.checkDeletedDate(address.getDeletedDate());
        address.setDeletedDate(LocalDateTime.now());
        addressRepository.save(address);

        DeletedAddressResponse deletedAddressResponse=AddressMapper.INSTANCE.deleteAddressResponseFromAddress(address);
        deletedAddressResponse.setCityId(address.getCity().getId());
        deletedAddressResponse.setCustomerId(address.getCustomer().getId());
        return deletedAddressResponse;

    }
}
