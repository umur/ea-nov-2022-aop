package com.gyawalirajiv.data.controller;

import com.gyawalirajiv.data.models.DTOs.AddressDTO;
import com.gyawalirajiv.data.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public AddressDTO save(@RequestBody AddressDTO addressDTO){
        return addressService.save(addressDTO);
    }

    @GetMapping
    public List<AddressDTO> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDTO find(@PathVariable Long id){
        return addressService.find(id);
    }

    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable Long id, @RequestBody AddressDTO addressDTO){
        return addressService.update(id, addressDTO);
    }

    @DeleteMapping("/{id}")
    public AddressDTO delete(@PathVariable Long id){
        return addressService.delete(id);
    }

}
