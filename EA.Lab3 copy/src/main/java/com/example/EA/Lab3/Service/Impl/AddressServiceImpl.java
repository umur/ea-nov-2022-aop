package com.example.EA.Lab3.Service.Impl;

import com.example.EA.Lab3.DTO.AddressDTO;
import com.example.EA.Lab3.Entity.Address;
import com.example.EA.Lab3.Repo.AddressRepo;
import com.example.EA.Lab3.Service.AddressService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    public List<AddressDTO> findAll(){
        List<AddressDTO> mappedAddress = new ArrayList<>();
        addressRepo.findAll().forEach(address -> mappedAddress.add(modelMapper.map(address, AddressDTO.class)));
        return mappedAddress;
    }
    public AddressDTO save(AddressDTO address){
        Address mappedAddress = modelMapper.map(address, Address.class);
        return modelMapper.map(addressRepo.save(mappedAddress), AddressDTO.class);
    }
    public AddressDTO update(Long id, AddressDTO address){
        Address mappedAddress = modelMapper.map(address, Address.class);
        Address updatedAddress = addressRepo.save(mappedAddress);
        return modelMapper.map(updatedAddress, AddressDTO.class);
    }

    public void delete(Long id){
        Address address = addressRepo.findById(id).orElseThrow(() -> new RuntimeException("invalid ID !"));
        addressRepo.delete(address);
        //modelMapper.map(address, AddressDTO.class);
    }
}
