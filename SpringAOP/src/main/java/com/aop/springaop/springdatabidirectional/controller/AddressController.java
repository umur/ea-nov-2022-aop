package com.aop.springaop.springdatabidirectional.controller;

import com.aop.springaop.aspectAdvice.ExecutionTime;
import com.aop.springaop.springdatabidirectional.DTOs.AddressDTO;
import com.aop.springaop.springdatabidirectional.entity.Address;
import com.aop.springaop.springdatabidirectional.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")

public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private ModelMapper modelMapper;
    @ExecutionTime
    @GetMapping
    public List<AddressDTO> getAddresses() {
        return addressService.getAll().stream().map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }
    @ExecutionTime
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO addressDTO) {
        Address addressRequest = modelMapper.map(addressDTO, Address.class);
        Address address = addressService.save(addressRequest);
        AddressDTO addressResponse = modelMapper.map(address, AddressDTO.class);
        return new ResponseEntity<AddressDTO>(addressResponse, HttpStatus.CREATED);
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        Address address = addressService.getById(id);
        AddressDTO responseAddress = modelMapper.map(address, AddressDTO.class);
        return ResponseEntity.ok().body(responseAddress);
    }
    @ExecutionTime
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddressById(@PathVariable(name = "id") Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity("Successfully deleted",HttpStatus.OK);
    }
}
