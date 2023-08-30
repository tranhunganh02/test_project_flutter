package com.example2.demo2.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example2.demo2.exception.UserNotFound;
import com.example2.demo2.model.User;
import com.example2.demo2.repository.UserRepository;
import com.example2.demo2.service.UserService;

@RestController

public class AppController {
     @Autowired
     private UserRepository userRepository;
     @Autowired
     private UserService userService;

     @PostMapping("/user")
     User newUser(@RequestBody User newUser){
          return userService.createUser(newUser);
     }
     
     @GetMapping("/users")
     List<User> getAllUsers() {
         return userService.getAllUser();
     } 
 
     @GetMapping("/user/{id}")
     
     Object getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return Collections.singletonMap("error", "User"+ id+" not found");
        }
     }
     @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFound(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFound(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

    @GetMapping("/users/{limit}")
     List<User> getListUserLimit(@PathVariable int limit) {
         return userService.getListLimit(limit);
     } 

}
