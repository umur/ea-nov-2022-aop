package com.example.eanov2022aop.service;


import com.example.eanov2022aop.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public List <AddressDto> findAll ();

    public AddressDto findAddressById (Integer id);

    void create (AddressDto addressDto);

    void delete (Integer id);

    void update(Integer id,String street,String zipcode,String city);
}
