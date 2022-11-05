package com.miu.edu.aop.repository;

import com.miu.edu.aop.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

    List<Address> findAll();

    Address getByUserId(int userId);
}
