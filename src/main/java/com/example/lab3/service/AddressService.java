package com.example.lab3.service;

import com.example.lab3.dto.AddressDto;
import com.example.lab3.entity.bidirectional.Address;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAll();
    AddressDto getAddressById(Long id);
    AddressDto createAddress(Address address);
    void deleteAddressById(Long id);
    AddressDto updateAddress(Long id, Address address);

}
