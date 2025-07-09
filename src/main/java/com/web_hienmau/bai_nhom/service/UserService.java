package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.User;
import com.web_hienmau.bai_nhom.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> searchUsers(String searchTerm) {
        return userRepository.findAll().stream()
                .filter(user -> user.getFullName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                                 user.getEmail().toLowerCase().contains(searchTerm.toLowerCase()) ||
                                 user.getId().toString().contains(searchTerm))
                .toList();
    }
}