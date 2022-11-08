package com.example.lab3.repository;

import com.example.lab3.entity.bidirectional.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Long> {
}
