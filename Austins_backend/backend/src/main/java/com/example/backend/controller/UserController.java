package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController{

        @Autowired
        private UserRepository userRepository;

        //Sending data to database
        @PostMapping("/user")
        User newUser(@RequestBody User newUser){
                return userRepository.save(newUser);
        }

        //Getting data from database
        @GetMapping("/user")
        List<User> getAllUsers(){
                return userRepository.findAll();
        }

        @GetMapping("/user/{id}")
        User getUserById(@PathVariable int id){
                return userRepository.findById(id)
                        .orElseThrow(()->new UserNotFoundException(id));
        }

        //Edit user
        @PutMapping("/user/{id}")
        User updateUser(@RequestBody User newUser, @PathVariable int id) {
                return userRepository.findById(id)
                        .map(user -> {
                                user.setUsername(newUser.getUsername());
                                user.setPassword(newUser.getPassword());
                                return userRepository.save(user);
                        }).orElseThrow(()->new UserNotFoundException(id));
        }

        //Delete user
        @DeleteMapping("/user/{id}")
        String deleteUser(@PathVariable int id) {
                if (!userRepository.existsById(id)) {
                        throw new UserNotFoundException(id);
                }
                userRepository.deleteById(id);
                return "User with id " + id + " has been deleted.";
        }
}