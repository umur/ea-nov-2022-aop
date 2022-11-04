package com.example.eanov2022springdataI.service;

import com.example.eanov2022springdataI.entity.Address;
import com.example.eanov2022springdataI.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends CrudService<Address, AddressRepository>{

    public AddressService(AddressRepository repository) {
        super(repository);
    }
}
