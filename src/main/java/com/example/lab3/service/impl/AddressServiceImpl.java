package com.example.lab3.service.impl;

import com.example.lab3.aspect.annotation.ExecutionTime;
import com.example.lab3.dto.AddressDto;
import com.example.lab3.entity.bidirectional.Address;
import com.example.lab3.mapper.Mapper;
import com.example.lab3.repository.AddressRepo;
import com.example.lab3.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;
    private Mapper mapper = new Mapper<Address, AddressDto>(Address.class, AddressDto.class);
    @ExecutionTime
    @Override
    public List<AddressDto> getAll() {
        return mapper.toListDto((List<Address>) addressRepo.findAll());
    }

    @Override
    public AddressDto getAddressById(Long id) {
        return (AddressDto) mapper.toDto(addressRepo.findById(id).get());
    }

    @Override
    public AddressDto createAddress(Address address) {
        return (AddressDto) mapper.toDto(addressRepo.save(address));
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepo.deleteById(id);
    }

    @Override
    public AddressDto updateAddress(Long id, Address a) {
        Address address = addressRepo.findById(id).get();
        if(Objects.nonNull(a.getCity())){
            address.setCity(a.getCity());
        }
        if(Objects.nonNull(a.getZip())){
            address.setZip(a.getZip());
        }
        if(Objects.nonNull(a.getStreet())){
            address.setStreet(a.getStreet());
        }
        return (AddressDto) mapper.toDto(address);
    }
}
