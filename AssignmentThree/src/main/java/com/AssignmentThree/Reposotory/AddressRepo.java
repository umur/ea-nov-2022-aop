package com.AssignmentThree.Reposotory;

import com.AssignmentThree.Entities.Addresses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepo extends CrudRepository<Addresses , Integer> {

    Addresses save( Addresses addresses);

    List<Addresses> findAll();
    void deleteById(Integer addressId);


}
