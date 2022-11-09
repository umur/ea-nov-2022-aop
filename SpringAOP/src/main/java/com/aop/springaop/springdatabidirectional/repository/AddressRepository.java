package com.aop.springaop.springdatabidirectional.repository;


import com.aop.springaop.springdatabidirectional.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}
