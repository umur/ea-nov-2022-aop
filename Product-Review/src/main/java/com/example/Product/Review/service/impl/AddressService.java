package com.example.Product.Review.service.impl;

import com.example.Product.Review.entities.join_column.Address;
import com.example.Product.Review.repo.AddressRepo;
import com.example.Product.Review.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {

    private final AddressRepo addressRepo;
    @Override
    public List<Address> findAll() {
        return (List<Address>) addressRepo.findAll();
    }

    @Override
    public Address findById(long id) {
        return addressRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void update(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void deleteById(long id) {
        addressRepo.deleteById(id);
    }

    @Override
    public void delete(Address address) {
        addressRepo.delete(address);
    }
}
