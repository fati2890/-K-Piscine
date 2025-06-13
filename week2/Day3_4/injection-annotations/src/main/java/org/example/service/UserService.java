package org.example.service;

import org.example.model.User;

import java.util.List;


public interface UserService {
    void createUser(String name, String email);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}