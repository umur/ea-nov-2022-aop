package com.example.eanov2022aop.service;



import com.example.eanov2022aop.dto.UsersDto;

import java.util.List;

public interface UsersService {
    public List<UsersDto> findAll ();

    public UsersDto findUsersById (Integer id);

    void createUsers (UsersDto usersDto);

    void deleteUsers (Integer id);

    void updateUsers (Integer id,String email,String firstname,String lastname);
}
