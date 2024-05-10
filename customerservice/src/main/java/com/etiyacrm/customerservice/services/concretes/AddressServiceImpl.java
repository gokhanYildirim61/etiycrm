package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
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


    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        Address address= AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);
        Address createdAddress= addressRepository.save(address);
        return AddressMapper.INSTANCE.createdAddressResponseFromAddress(createdAddress);

    }

    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        Address address = addressRepository.findById(updateAddressRequest.getId()).get();
        Address updatedAddress=AddressMapper.INSTANCE.addressFromAddressUpdatedAddressRequest(updateAddressRequest);
        updatedAddress=addressRepository.save(updatedAddress);
        return AddressMapper.INSTANCE.updateAddressResponseFromAddress(updatedAddress);
    }

    @Override
    public GetAddressResponse getById(String id) {
        Address address=addressRepository.findById(id).get();
        return AddressMapper.INSTANCE.getAddressResponse(address);
    }

    @Override
    public GetListResponse<GetAllAddressResponse> getALLWithPaging(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getPage());
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
        return AddressMapper.INSTANCE.deleteAddressResponseFromAddress(address);

    }
}
