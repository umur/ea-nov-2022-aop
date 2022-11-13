package com.miu.edu.aop.service.impl;

import com.miu.edu.aop.annotation.ExecutionTime;
import com.miu.edu.aop.dto.AddressDto;
import com.miu.edu.aop.entity.Address;
import com.miu.edu.aop.entity.User;
import com.miu.edu.aop.repository.AddressRepository;
import com.miu.edu.aop.repository.UserRepository;
import com.miu.edu.aop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @ExecutionTime
    public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll().stream().map(AddressDto::convertFrom).toList();
    }

    @Override
    @ExecutionTime
    public AddressDto getAddressDtoById(int id) {
        return AddressDto.convertFrom(this.getAddressById(id));
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    @ExecutionTime
    public AddressDto getAddressByUserId(int userId) {
        return AddressDto.convertFrom(addressRepository.getByUserId(userId));
    }

    @Override
    public void updateAddress(int id, AddressDto address) {
        addressRepository.findById(id).ifPresent(a -> {
            a.setCity(address.getCity());
            a.setStreet(address.getStreet());
            a.setZip(address.getZip());
            addressRepository.save(a);
        });

    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        return AddressDto.convertFrom(addressRepository.save(AddressDto.convertTo(addressDto)));
    }

    @Override
    public void removeById(int id) {
        User user = userRepository.findByAddressId(id);
        if (user != null) {
            user.setAddress(null);
        }
        addressRepository.deleteById(id);
    }
}
