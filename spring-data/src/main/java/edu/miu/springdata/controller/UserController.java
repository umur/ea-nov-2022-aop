package edu.miu.springdata.controller;

import edu.miu.springdata.aspect.annotation.ExecutionTime;
import edu.miu.springdata.entity.User;
import edu.miu.springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/springdata/user")
public class UserController {

    private final UserService userService;

    @ExecutionTime
    @PostMapping
    public String create(@RequestBody User user) {
        try {
            userService.save(user);

            return "User saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving User.";
        }
    }

    @ExecutionTime
    @PutMapping
    public String update(@RequestBody User user) {
        try {
            userService.save(user);

            return "User updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating User.";
        }
    }

    @ExecutionTime
    @DeleteMapping("/{userId}")
    public String delete(@PathVariable Long userId) {
        try {
            userService.delete(userId);

            return "User deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting User.";
        }
    }

    @ExecutionTime
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @ExecutionTime
    @GetMapping("/{userId}")
    public User getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

}
