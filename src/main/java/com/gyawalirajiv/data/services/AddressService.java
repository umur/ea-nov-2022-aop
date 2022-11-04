package com.gyawalirajiv.data.services;

import com.gyawalirajiv.data.models.DTOs.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO save(AddressDTO addressDTO);

    List<AddressDTO> findAll();

    AddressDTO find(Long id);

    AddressDTO update(Long id, AddressDTO addressDTO);

    AddressDTO delete(Long id);
}
