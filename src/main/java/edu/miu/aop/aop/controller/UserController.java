package edu.miu.aop.aop.controller;

import edu.miu.aop.aop.dto.RequestUserDTO;
import edu.miu.aop.aop.entity.User;
import edu.miu.aop.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public RequestUserDTO createUser(HttpServletRequest request, @RequestBody RequestUserDTO dto) {
        return service.save(request, dto);
    }

    @PutMapping("/{id}")
    public RequestUserDTO updateUser(@PathVariable Long id, @RequestBody RequestUserDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }
}
