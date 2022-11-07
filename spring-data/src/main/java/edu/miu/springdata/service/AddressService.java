package edu.miu.springdata.service;

import edu.miu.springdata.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    void save(Address address);

    void delete(Long addressId);

    Address getById(Long addressId);

    List<Address> getAll();

}
