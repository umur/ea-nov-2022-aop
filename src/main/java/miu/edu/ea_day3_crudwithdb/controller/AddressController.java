package miu.edu.ea_day3_crudwithdb.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.AddressDto;
import miu.edu.ea_day3_crudwithdb.DTO.CategoryDto;
import miu.edu.ea_day3_crudwithdb.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public void save(@RequestBody AddressDto a) {
        addressService.save(a);
    }

    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getById(@PathVariable int id) {
        var address = addressService.getById(id);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody AddressDto address) {
        addressService.update(id, address);
    }

}
