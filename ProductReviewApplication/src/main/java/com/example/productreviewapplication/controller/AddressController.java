package com.example.productreviewapplication.controller;

import com.example.productreviewapplication.model.Address;
import com.example.productreviewapplication.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    public AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public void addAddress(HttpServletRequest request, @RequestBody Address address){
        addressService.addAddress(request, address);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable Integer id, String streetName){
        addressService.updateAddress(id, streetName);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
    }

    @GetMapping
    public Iterable<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Integer id){
       return addressService.getAddressById(id);
    }
}
