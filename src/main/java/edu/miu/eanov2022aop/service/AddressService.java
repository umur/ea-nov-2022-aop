package edu.miu.eanov2022aop.service;

import edu.miu.eanov2022aop.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    public List<Address> getAll();
    public Optional<Address> getById(long id);
    public Address add(Address address);
    public Address updateById(long id, Address address);
    public void deleteById(long id);
}
