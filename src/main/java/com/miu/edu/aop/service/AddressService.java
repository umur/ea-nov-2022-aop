package com.miu.edu.aop.service;

import com.miu.edu.aop.dto.AddressDto;
import com.miu.edu.aop.entity.Address;

import java.util.List;

public interface AddressService {

    /**
     * get All Addresses
     * @return Addresses
     */
    List<AddressDto> getAllAddresses();

    /**
     * Get Address by id
     * @param id
     * @return AddressDto
     */
    AddressDto getAddressDtoById(int id);

    /**
     * Get Address by id
     * @param id
     * @return address
     */
    Address getAddressById(int id);

    /**
     * Get Address by userId
     * @param userId
     * @return address
     */
    AddressDto getAddressByUserId(int userId);

    /**
     * Update an address
     * @param id
     * @param address
     */
    void updateAddress(int id, AddressDto address);

    /**
     * Add an address
     * @param address
     */
    AddressDto addAddress(AddressDto address);

    /**
     * Remove an address by id
     * @param id
     */
    void removeById(int id);

}
