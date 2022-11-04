package miu.edu.aop.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.annotation.ExecutionTime;
import miu.edu.aop.dto.AddressDTO;
import miu.edu.aop.service.AddressServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl service;

    @GetMapping()
    @ExecutionTime
    public List<AddressDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public AddressDTO create(@RequestBody AddressDTO address) {
        return service.save(address);
    }

    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable Long id, @RequestBody AddressDTO address) {
        address.setId(id);
        return service.save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}