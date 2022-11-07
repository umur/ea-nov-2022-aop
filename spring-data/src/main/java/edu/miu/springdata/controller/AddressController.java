package edu.miu.springdata.controller;

import edu.miu.springdata.aspect.annotation.ExecutionTime;
import edu.miu.springdata.entity.Address;
import edu.miu.springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/springdata/address")
public class AddressController {

    private final AddressService addressService;

    @ExecutionTime
    @PostMapping
    public String create(@RequestBody Address address) {
        try {
            addressService.save(address);

            return "Address saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Address.";
        }
    }

    @ExecutionTime
    @PutMapping
    public String update(@RequestBody Address address) {
        try {
            addressService.save(address);

            return "Address updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Address.";
        }
    }

    @ExecutionTime
    @DeleteMapping("/{addressId}")
    public String delete(@PathVariable Long addressId) {
        try {
            addressService.delete(addressId);

            return "Address deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Address.";
        }
    }

    @ExecutionTime
    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @ExecutionTime
    @GetMapping("/{addressId}")
    public Address getById(@PathVariable Long addressId) {
        return addressService.getById(addressId);
    }

}
