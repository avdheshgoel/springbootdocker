package com.example.springbootdocker.api;


import com.example.springbootdocker.service.UserService;
import io.swagger.api.UsersApi;
import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserApiController implements UsersApi {


    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<List<User>> usersGet() {
        // Sample implementation
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> usersIdGet(Integer id) {
        // Sample implementation
        User user = userService.getUserById(Long.valueOf(id));
        return ResponseEntity.ok(user);
    }

//    @Override
//    public ResponseEntity<User> usersPost(User user) {
//        // Sample implementation
//        user.setId(3); // Simulating database ID assignment
//        return ResponseEntity.status(201).body(user);
//
//    }
}