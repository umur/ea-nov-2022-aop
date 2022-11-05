package edu.miu.aop.aop.controller;

import edu.miu.aop.aop.dto.RequestAddressDTO;
import edu.miu.aop.aop.entity.Address;
import edu.miu.aop.aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService service;

    @PostMapping
    public RequestAddressDTO createAddress(@RequestBody RequestAddressDTO address) {
        return service.save(address);
    }

    @PutMapping("/{id}")
    public RequestAddressDTO updateAddress(@PathVariable Long id, @RequestBody RequestAddressDTO address) {
        return service.update(id, address);
    }

    @GetMapping
    public List<Address> getAllAddress() {
        return service.getAllAddress();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteAddress(@PathVariable Long id) {
        return service.deleteAddress(id);
    }
}
