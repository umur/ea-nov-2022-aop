package com.example.productreviewapplication.repository;

import com.example.productreviewapplication.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
