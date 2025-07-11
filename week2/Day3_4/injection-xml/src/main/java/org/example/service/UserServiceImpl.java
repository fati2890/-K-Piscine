package org.example.service;

import org.example.model.User;
import org.example.model.UserRepo;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepo userRepository;

    // Injection via constructeur
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String name, String email) {
        User user = new User(null, name, email);
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}