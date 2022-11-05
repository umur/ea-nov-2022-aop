package edu.miu.aop.aop.service;

import edu.miu.aop.aop.dto.RequestUserDTO;
import edu.miu.aop.aop.entity.User;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
public interface UserService {

    RequestUserDTO save(RequestUserDTO user);

    RequestUserDTO update(Long id, RequestUserDTO user);

    List<User> getAllUser();

    Boolean deleteUser(Long id);
}
