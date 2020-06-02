package com.example.crm.controllers;

import com.example.crm.entities.Role;
import com.example.crm.entities.User;
import com.example.crm.repositories.UserRepo;
import com.example.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<User> getAllUser(@PathVariable("id")Long id) {
        return userRepo.findById(id);
    }

    @PutMapping("/{id}")
    public void userRole(@PathVariable("id") Long id) {
    User user1 = userRepo.findById(id).get();
        if(user1.getRole()==Role.USER){
            user1.setRole(Role.ADMIN); }
        userRepo.save(user1);
     }
}
