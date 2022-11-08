package com.example.productreview.service.Impl;

import com.example.productreview.entity.uni_and_bi_directional.Address;
import com.example.productreview.repository.AddressRepo;
import com.example.productreview.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepo addressRepo;

    @Override
    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepo.findById(id).get();
    }

    @Override
    public void add(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void update(Long id, Address address) {
        Address add = addressRepo.findById(id).get();
        add.setCity(address.getCity());
        add.setZip(address.getZip());
        add.setStreet(address.getStreet());
        addressRepo.save(add);
    }

    @Override
    public void delete(Long id) {
        addressRepo.deleteById(id);
    }
}
