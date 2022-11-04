package com.gyawalirajiv.data.services.impl;

import com.gyawalirajiv.data.models.DTOs.AddressDTO;
import com.gyawalirajiv.data.models.Address;
import com.gyawalirajiv.data.repository.AddressRepository;
import com.gyawalirajiv.data.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        return modelMapper.map(addressRepository.save(modelMapper.map(addressDTO, Address.class)), AddressDTO.class);
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream().map(u -> modelMapper.map(u, AddressDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AddressDTO find(Long id) {
        return modelMapper.map(addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!")), AddressDTO.class);
    }

    @Override
    public AddressDTO update(Long id, AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address = addressRepository.save(address);
        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public AddressDTO delete(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!"));
        addressRepository.delete(address);
        return modelMapper.map(address, AddressDTO.class);
    }
}
