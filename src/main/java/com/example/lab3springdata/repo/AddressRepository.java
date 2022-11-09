package com.example.lab3springdata.repo;

import com.example.lab3springdata.model.uni_directional.Address;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<Address,Integer> {
}
