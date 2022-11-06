package com.AssignmentThree.Service;

import com.AssignmentThree.Entities.Addresses;

import java.util.List;

public interface AddressService {

    List<Addresses> getAll();

    void add(Addresses address);

    void delete(int addressId);

//    void update(Addresses address);

}
