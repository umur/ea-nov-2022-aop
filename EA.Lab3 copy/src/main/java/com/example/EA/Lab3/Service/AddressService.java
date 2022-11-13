package com.example.EA.Lab3.Service;

import com.example.EA.Lab3.DTO.AddressDTO;

import java.util.List;

public interface AddressService {
     List<AddressDTO> findAll();
     AddressDTO save(AddressDTO address);
     AddressDTO update(Long id, AddressDTO address);
     void delete(Long id);

}
