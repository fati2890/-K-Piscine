package org.example.model;

import java.util.List;

public interface UserRepo {
    void save(User user);
    User findById(Long id);
    List<User> findAll();
    void delete(Long id);
}