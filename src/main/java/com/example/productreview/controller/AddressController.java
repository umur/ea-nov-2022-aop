package com.example.productreview.controller;

import com.example.productreview.entity.uni_and_bi_directional.Address;
import com.example.productreview.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    List<Address> findAll(){
        return addressService.findAll();
    }

    @PostMapping
    String addNew(@RequestBody Address Address){
        addressService.add(Address);
        return "Address Saved!!!";
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Address address){
        Address oldAddress;
        try {
            oldAddress = addressService.findById(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }

        oldAddress.setStreet(address.getStreet());
        oldAddress.setCity(address.getCity());

        addressService.add(oldAddress);

        return "Address updated!!!";
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam Long id){
        try {
            addressService.delete(id);
        }catch (Exception ex){
            return "Error -> " + ex.toString();
        }
        return "Address deleted!!!";
    }
}
