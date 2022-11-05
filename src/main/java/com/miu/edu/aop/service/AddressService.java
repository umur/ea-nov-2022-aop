package com.miu.edu.aop.service;

import com.miu.edu.aop.dto.AddressDto;

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
     * @return address
     */
    AddressDto getAddressById(int id);

    /**
     * Get Address by userId
     * @param userId
     * @return address
     */
    AddressDto getAddressByUserId(int userId);

    /**
     * Update an address
     * @param address
     */
    void updateAddress(AddressDto address);

    /**
     * Add an address
     * @param address
     */
    void addAddress(AddressDto address);

    /**
     * Remove an address by id
     * @param id
     */
    void removeById(int id);

}
