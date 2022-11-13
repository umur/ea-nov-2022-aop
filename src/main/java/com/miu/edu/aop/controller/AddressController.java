package com.miu.edu.aop.controller;

import com.miu.edu.aop.dto.AddressDto;
import com.miu.edu.aop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable int id) {
        return addressService.getAddressDtoById(id);
    }

    @GetMapping("/user/{id}")
    public AddressDto getAddressByUserId(@PathVariable int id) {
        return addressService.getAddressDtoById(id);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable int id, @RequestBody AddressDto address) {
        addressService.updateAddress(id, address);
    }

    @PostMapping
    public AddressDto addAddress(@RequestBody AddressDto address) {
        return addressService.addAddress(address);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        addressService.removeById(id);
    }
}
