package com.example.productreviewapplication.service.impl;

import com.example.productreviewapplication.aspect.annotation.ExecutionTime;
import com.example.productreviewapplication.aspect.annotation.ValidHeader;
import com.example.productreviewapplication.model.Address;
import com.example.productreviewapplication.repository.AddressRepository;
import com.example.productreviewapplication.service.AddressService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    public AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    @ExecutionTime
    @ValidHeader
    public void addAddress(HttpServletRequest request, Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Integer id, String streetName) {
        //Optional<Address> address = addressRepository.findById(id);
        Address address = addressRepository.findById(id).get();
        if(address != null){
            address.setStreet(streetName);
        }
        addressRepository.save(address);
        return address;
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    @ExecutionTime
    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    @ExecutionTime
    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }
}
