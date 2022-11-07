package edu.miu.eanov2022aop.controller;

import edu.miu.eanov2022aop.model.Address;
import edu.miu.eanov2022aop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Address> address = addressService.getById(id);
        if(address.isPresent()) return new ResponseEntity<>(address, HttpStatus.OK);

        return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.add(address), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Address address) {
        return new ResponseEntity<>(addressService.updateById(id, address), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully !!", HttpStatus.OK);
    }
}
