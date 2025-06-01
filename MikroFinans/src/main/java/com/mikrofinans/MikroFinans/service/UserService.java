package com.mikrofinans.MikroFinans.service;

import com.mikrofinans.MikroFinans.model.User;
import com.mikrofinans.MikroFinans.repository.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Yeni kullanıcı ekleme

    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Tüm kullanıcıları listeleme
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ID ile kullanıcı bulma
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("ID: " + id + " ile kullanıcı bulunamadı."));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
