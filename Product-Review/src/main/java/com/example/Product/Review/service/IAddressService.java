package com.example.Product.Review.service;

import com.example.Product.Review.entities.join_column.Address;

import java.util.List;

public interface IAddressService {

    List<Address> findAll();
    Address findById(long id);
    void save(Address address);
    void update(Address address);
    void deleteById(long id);
    void delete(Address address);
}
