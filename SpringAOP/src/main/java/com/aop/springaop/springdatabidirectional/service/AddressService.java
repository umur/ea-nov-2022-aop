package com.aop.springaop.springdatabidirectional.service;


import com.aop.springaop.springdatabidirectional.entity.Address;

import java.util.List;

public interface AddressService {

    Address save(Address address);
    Address updateAddress(Address address);
    Address getById(Long id);
    void deleteAddress(Long id);
    List<Address> getAll();
}
