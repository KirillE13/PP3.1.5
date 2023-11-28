package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void saveUser(User user, String username);

    User getUser(Long id);

    void deleteUser(Long id);

    List<Role> getAllRoles();
}
