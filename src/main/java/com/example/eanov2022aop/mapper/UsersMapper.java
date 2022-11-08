package com.example.eanov2022aop.mapper;


import com.example.eanov2022aop.dto.UsersDto;
import com.example.eanov2022aop.entity.Users;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersMapper {
    private final ModelMapper modelMapper;

    public UsersDto toDto(Users users) {
        return modelMapper.map(users, UsersDto.class);
    }

    public List <UsersDto> toDtos(List<Users> users) {
        return users.stream()
                .map(this::toDto)
                .toList();
    }

    public Users toEntity(UsersDto usersDto) {
        return modelMapper.map(usersDto, Users.class);
    }

    public List<Users> toEntities(List<UsersDto> usersDtos) {
        return usersDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
