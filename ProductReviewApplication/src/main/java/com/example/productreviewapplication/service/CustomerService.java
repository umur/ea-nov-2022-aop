package com.example.productreviewapplication.service;

import com.example.productreviewapplication.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public void addCustomer(Customer customer);

    Customer updateCustomerEmail(Integer id, String email);

    public void deleteCustomer(Integer id);
    public Iterable<Customer> getAllCustomers();
    public Customer getCustomerById(Integer id);
}
