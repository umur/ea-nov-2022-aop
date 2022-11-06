package com.example.productreviewapplication.service;

import com.example.productreviewapplication.model.Address;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface AddressService {
    public void addAddress(HttpServletRequest request, Address address);
    public Address updateAddress(Integer id, String streetName);
    public void deleteAddress(Integer id);
    public Iterable<Address> getAllAddresses();
    public Address getAddressById(Integer id);
}
