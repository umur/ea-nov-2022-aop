package labs.lab5.Service;

import labs.lab5.Entity.UniUser;
import labs.lab5.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UniUser> getUsers(){
        return this.userRepository.findAll();
    }

    public UniUser getUserById(String id){
        return this.userRepository.findById(id).orElse(null);
    }

    public UniUser saveUser(UniUser c){
        return this.userRepository.save(c);
    }

    public void deleteUserById(String id){
        this.userRepository.deleteById(id);
    }
}
