package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        final Role userRole = new Role(1L, "ROLE_USER");
        roleRepository.save(userRole);

        final Role adminRole = new Role(2L, "ROLE_ADMIN");
        roleRepository.save(adminRole);

        final User admin = new User("AdminName", "AdminSurname", 30, "admin@admin.com");
        admin.setId(1L);
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRoles(new HashSet<>(List.of(userRole, adminRole)));
        userRepository.save(admin);

        final User user = new User("UserName", "UserSurname", 20, "user@user.com");
        user.setId(2L);
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRoles(new HashSet<>(List.of(userRole)));
        userRepository.save(user);
    }
}
