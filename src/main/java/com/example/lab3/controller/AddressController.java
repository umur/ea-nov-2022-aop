package com.example.lab3.controller;

import com.example.lab3.dto.AddressDto;
import com.example.lab3.entity.bidirectional.Address;
import com.example.lab3.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping
    public List<AddressDto> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    public AddressDto createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public AddressDto updateAddress(@PathVariable Long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id){
        addressService.deleteAddressById(id);
    }
}
