package com.example.productreview.service;

import com.example.productreview.entity.uni_and_bi_directional.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address findById(Long id);
    void add(Address user);
    void update(Long id, Address address);
    void delete(Long id);
}
