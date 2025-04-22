package com.example.springbootdocker.service;

import com.example.springbootdocker.entity.UserEntity;
import com.example.springbootdocker.repository.UserRepository;
import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Convert User (API model) to UserEntity (JPA entity)
    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        return entity;
    }

    // Convert UserEntity (JPA entity) to User (API model)
    private User toModel(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        return user;
    }

    // Save a new user
    public User saveUser(User user) {
        UserEntity savedEntity = userRepository.save(toEntity(user));
        return toModel(savedEntity);
    }

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    // Fetch a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }
}
