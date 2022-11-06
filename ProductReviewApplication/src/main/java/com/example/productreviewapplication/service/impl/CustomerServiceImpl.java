package com.example.productreviewapplication.service.impl;

import com.example.productreviewapplication.model.Customer;
import com.example.productreviewapplication.repository.CustomerRepository;
import com.example.productreviewapplication.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    public CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomerEmail(Integer id, String email) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer != null){
            customer.setEmail(email);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }
}
