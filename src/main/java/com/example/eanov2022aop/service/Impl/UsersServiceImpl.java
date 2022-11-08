package com.example.eanov2022aop.service.Impl;


import com.example.eanov2022aop.dto.UsersDto;
import com.example.eanov2022aop.entity.Users;
import com.example.eanov2022aop.mapper.UsersMapper;
import com.example.eanov2022aop.repository.UsersRepo;
import com.example.eanov2022aop.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepo usersRepo;
    private final UsersMapper usersMapper;

    @Override
    @Transactional
    public List <UsersDto> findAll () {
        return usersMapper.toDtos ((List <Users>) usersRepo.findAll ());
    }

    @Override
    @Transactional
    public UsersDto findUsersById (Integer id) {
        return usersMapper.toDto (usersRepo.findUsersById (id));
    }

    @Override
    @Transactional
    public void createUsers (UsersDto usersDto) {
        Users users = usersMapper.toEntity (usersDto);
        usersRepo.save (users);
    }

    @Override
    public void deleteUsers (Integer id) {
        boolean exists = usersRepo.existsById (id);
        if(!exists){
            throw new IllegalStateException ("User id:"+id+"does not exist");
        }
        usersRepo.deleteById (id);

    }

    @Override
    @Transactional
    public void updateUsers (Integer id,String email,String firstname,String lastname) {
        Users user = usersRepo.findById (id)
                .orElseThrow (()->new IllegalStateException (
                        "User id:"+id+"does not exist"));

        if(email !=null &&
                email.length ()>0 &&
                !Objects.equals (user.getEmail (),email)){
            Optional<Users> users = usersRepo.findUsersByEmail (email);
            if (users.isPresent ()){
                throw new IllegalStateException (email+"already taken");
            }
            user.setEmail (email);
        }

        if(firstname !=null &&firstname.length ()>0 && !Objects.equals (user.getFirstname (),firstname)){
            user.setFirstname (firstname);
        }

        if(lastname !=null &&lastname.length ()>0 && !Objects.equals (user.getLastname (),lastname)){
            user.setLastname (lastname);
        }
    }

}
