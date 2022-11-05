package edu.miu.aop.aop.service.impl;

import edu.miu.aop.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.aop.aspect.annotation.ValidatePostMethod;
import edu.miu.aop.aop.dto.RequestUserDTO;
import edu.miu.aop.aop.entity.User;
import edu.miu.aop.aop.repository.AddressRepository;
import edu.miu.aop.aop.repository.UserRepository;
import edu.miu.aop.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AddressRepository addressRepository;

    @Override
    @ExecutionTime
    @ValidatePostMethod
    public RequestUserDTO save(HttpServletRequest request, RequestUserDTO user) {
        User u = new User();
        BeanUtils.copyProperties(user, u, "id");
        u.setAddress(addressRepository.findById(user.getAddressId()).get());
        repository.save(u);
        return user;
    }

    @Override
    @ExecutionTime
    public RequestUserDTO update(Long id, RequestUserDTO user) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User o = optional.get();
        BeanUtils.copyProperties(user, o, "id");
        o.setAddress(addressRepository.findById(user.getAddressId()).get());
        repository.save(o);
        return user;
    }

    @Override
    @ExecutionTime
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    @ExecutionTime
    public Boolean deleteUser(Long id) {
        repository.deleteById(id);
        return true;
    }
}
