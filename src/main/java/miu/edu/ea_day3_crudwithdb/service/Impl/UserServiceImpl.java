package miu.edu.ea_day3_crudwithdb.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.UserDto;
import miu.edu.ea_day3_crudwithdb.entity.User;
import miu.edu.ea_day3_crudwithdb.repository.UserRepository;
import miu.edu.ea_day3_crudwithdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public void save(UserDto user) {
        userRepository.save(mapper.map(user, User.class));
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getById(int id) {
        var user = userRepository.findById(id);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> result = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .map(u -> mapper.map(u, UserDto.class))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void update(int id, UserDto user) {
        var existingEntity = userRepository.findById(id).get();
        if (existingEntity != null) {
            existingEntity.setEmail(user.getEmail());
            existingEntity.setFirstname(user.getFirstName());
            existingEntity.setLastname(user.getLastName());
            userRepository.save(existingEntity);
        }
    }
}
