package com.miu.edu.aop.service.impl;

import com.miu.edu.aop.annotation.ExecutionTime;
import com.miu.edu.aop.dto.AddressDto;
import com.miu.edu.aop.dto.UserDto;
import com.miu.edu.aop.entity.Address;
import com.miu.edu.aop.entity.User;
import com.miu.edu.aop.repository.UserRepository;
import com.miu.edu.aop.service.AddressService;
import com.miu.edu.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService;

    @Override
    @ExecutionTime
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::convertFrom).toList();
    }

    @Override
    @ExecutionTime
    public UserDto getUserById(int id) {
        return UserDto.convertFrom(userRepository.findById(id).orElse(null));
    }

    @Override
    public AddressDto getAddressByUserId(int id) {
        return this.getUserById(id).getAddress();
    }
    @Override
    public void updateUser(UserDto user) {
        userRepository.findById(user.getId()).ifPresent(u -> {
            u.setFirstName(user.getFirstName());
            u.setLastname(user.getLastname());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            userRepository.save(u);
        });
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = UserDto.convertTo(userDto);
        AddressDto addressDto = userDto.getAddress();
        if (addressDto != null && addressDto.getId() > 0) {
            Address address = addressService.getAddressById(addressDto.getId());
            address.setUser(user);
            user.setAddress(address);
        }
        return UserDto.convertFrom(userRepository.save(user));
    }

    @Override
    public void removeById(int id) {
        userRepository.deleteById(id);
    }
}
