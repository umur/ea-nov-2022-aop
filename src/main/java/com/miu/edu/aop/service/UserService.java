package com.miu.edu.aop.service;


import com.miu.edu.aop.dto.AddressDto;
import com.miu.edu.aop.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * Get all users
     * @return users
     */
    List<UserDto> getAllUsers();

    /**
     * Get User By id
     *
     * @param id
     * @return a User
     */
    UserDto getUserById(int id);

    /**
     * Get Address by user id
     * @param id
     * @return AddressDto
     */
    AddressDto getAddressByUserId(int id);

    /**
     * Update a User
     * param id
     * @param user
     */
    void updateUser(int id, UserDto user);

    /**
     * Add a User
     * @param user
     */
    UserDto addUser(UserDto user);

    /**
     * Remove a User by id
     * @param id
     */
    void removeById(int id);

}
