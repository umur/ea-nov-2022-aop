package com.example.eanov2022springdataI.controller;

import com.example.eanov2022springdataI.entity.Address;
import com.example.eanov2022springdataI.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController extends CrudController<Address, AddressService>{

    public AddressController(AddressService service) {
        super(service);
    }
}
