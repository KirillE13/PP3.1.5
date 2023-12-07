package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User saveUser(User user, Long id);

    User getUser(Long id);

    void deleteUser(Long id);

    List<Role> getAllRoles();
}
