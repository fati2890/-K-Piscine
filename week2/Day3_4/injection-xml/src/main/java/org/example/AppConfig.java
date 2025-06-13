package org.example;

import org.example.model.UserRepo;
import org.example.model.UserRepoImpl;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;


public class AppConfig {

    @Bean
    public UserRepo userRepository() {
        return new UserRepoImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }
}