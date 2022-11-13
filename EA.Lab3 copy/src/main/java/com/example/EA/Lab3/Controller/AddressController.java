package com.example.EA.Lab3.Controller;

import com.example.EA.Lab3.DTO.AddressDTO;
import com.example.EA.Lab3.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDTO> findAll(){
        return addressService.findAll();
    }
    @PostMapping
    public AddressDTO save(@RequestBody AddressDTO address){
        return addressService.save(address);
    }
    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable Long id, @RequestBody AddressDTO address){
        return addressService.update(id, address);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         addressService.delete(id);
    }
}
