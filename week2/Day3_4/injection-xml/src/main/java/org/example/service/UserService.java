package org.example.service;
import java.util.List;
import org.example.model.User;


public interface UserService {
    void createUser(String name, String email);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}