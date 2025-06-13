package org.example;

import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);

        // Test des fonctionnalités
        userService.createUser("Alice", "alice@example.com");
        userService.createUser("Bob", "bob@example.com");

        System.out.println("All users: " + userService.getAllUsers());
        System.out.println("User 1: " + userService.getUserById(1L));

        userService.deleteUser(1L);
        System.out.println("All users after deletion: " + userService.getAllUsers());
    }
}