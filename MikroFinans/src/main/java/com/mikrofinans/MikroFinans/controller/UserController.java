package com.mikrofinans.MikroFinans.controller;

import com.mikrofinans.MikroFinans.model.User;
import com.mikrofinans.MikroFinans.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Yeni kullanıcı ekleme işlemi
    @PostMapping("/add")
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    // Tüm kullanıcıları listeleme işlemi
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Belirli bir kullanıcıyı ID ile getirme işlemi
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
