package com.example.eanov2022aop.service;

import com.example.eanov2022aop.entity.Address;
import com.example.eanov2022aop.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends CrudService<Address, AddressRepository>{

    public AddressService(AddressRepository repository) {
        super(repository);
    }
}
