package miu.edu.ea_day3_crudwithdb.service;

import miu.edu.ea_day3_crudwithdb.DTO.ProductDto;
import miu.edu.ea_day3_crudwithdb.DTO.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto user);

    void delete(int id);

    UserDto getById(int id);

    List<UserDto> getAll();

    void update(int id, UserDto user);
}
