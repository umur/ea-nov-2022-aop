package com.example.Product.Review.controller;

import com.example.Product.Review.entities.join_column.Address;
import com.example.Product.Review.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final IAddressService addressService;

    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Address address) {
        addressService.save(address);
    }

    @PutMapping
    public void update(@RequestBody Address address) {
        addressService.update(address);
    }

    @DeleteMapping
    public void delete(@RequestBody Address address) {
        addressService.delete(address);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        addressService.deleteById(id);
    }
}
