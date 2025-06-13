package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {
    private Map<Long, User> users = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            user.setId(currentId++);
        }
        users.put(user.getId(), user);
        System.out.println("User saved: " + user);
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void delete(Long id) {
        users.remove(id);
        System.out.println("User deleted with id: " + id);
    }
}