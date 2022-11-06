package com.example.productreviewapplication.controller;

import com.example.productreviewapplication.model.Customer;
import com.example.productreviewapplication.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    public CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomerEmail(@PathVariable Integer id, String email){
        customerService.updateCustomerEmail(id, email);
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }
}
