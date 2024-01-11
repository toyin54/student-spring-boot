package com.ajose.fullstackbackend.controller;

import com.ajose.fullstackbackend.exception.UserNotFoundException;
import  com.ajose.fullstackbackend.model.User;
import com.ajose.fullstackbackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/user")
    User newUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @GetMapping("/user")
    public List<User>  getAllUsers(){
        return userRepo.findAll();

    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepo.findById(id)
                .orElseThrow(
                        ()-> new UserNotFoundException(id));

    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser , Long id){
        return userRepo.findById(id).
                map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepo.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);
    }


}
