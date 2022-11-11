package com.AssignmentThree.Controller;


import com.AssignmentThree.Annotations.ExecutionTime;
import com.AssignmentThree.Entities.Addresses;
import com.AssignmentThree.Service.Implemintation.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("address")
@RestController
public class AddressController {

    @Autowired
    AddressServiceImpl addressService;

    @ExecutionTime
    @GetMapping("findall")
    public List<Addresses> findAll() {
        return addressService.getAll();
    }

    @DeleteMapping("deletebyid")
    public void delete(int addressId) {
        addressService.delete(addressId);
    }

    @PostMapping("post")
    public void update() {
        System.out.println("out");
    }

}
