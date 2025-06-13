package org.example.service;

import java.util.List;

import org.example.model.UserRepo;
import org.example.model.User;


public class UserServiceImpl implements UserService {
    private UserRepo UserRepo;

    // Injection via constructeur
    public UserServiceImpl(UserRepo UserRepo) {
        this.UserRepo = UserRepo;
    }

    @Override
    public void createUser(String name, String email) {
        User user = new User(null, name, email);
        UserRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return UserRepo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return UserRepo.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        UserRepo.delete(id);
    }
}