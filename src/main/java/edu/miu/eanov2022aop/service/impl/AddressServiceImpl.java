package edu.miu.eanov2022aop.service.impl;

import edu.miu.eanov2022aop.model.Address;
import edu.miu.eanov2022aop.repository.AddressRepository;
import edu.miu.eanov2022aop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    @Override
    public Optional<Address> getById(long id) {
        return addressRepo.findById(id);
    }

    @Override
    public Address add(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address updateById(long id, Address address) {
        Address newAddress = addressRepo.getReferenceById(id);
        newAddress.setCity(address.getCity());
        newAddress.setZip(address.getZip());
        newAddress.setUser(address.getUser());
        newAddress.setStreet(address.getStreet());
        return addressRepo.save(newAddress);
    }

    @Override
    public void deleteById(long id) {
        addressRepo.deleteById(id);
    }
}
