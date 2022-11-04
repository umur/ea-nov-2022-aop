package miu.edu.aop.service;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.dto.UserDTO;
import miu.edu.aop.model.User;
import miu.edu.aop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    static ModelMapper mapper = new ModelMapper();
    private static final Function<User, UserDTO> toDTO = item -> mapper.map(item, UserDTO.class);
    private static final Function<UserDTO, User> toEntity = item -> mapper.map(item, User.class);

    public List<UserDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> findOne(Long id) {
        return repository.findById(id)
                .map(toDTO);
    }

    public UserDTO save(UserDTO product) {
        return toDTO.apply(toEntity.apply(product));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
