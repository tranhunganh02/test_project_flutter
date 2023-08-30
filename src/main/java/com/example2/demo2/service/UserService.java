package com.example2.demo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example2.demo2.model.User;
import com.example2.demo2.repository.UserRepository;

@Service
public class UserService {

     @Autowired(required = true)
     private UserRepository userRepository;

     public List<User> getAllUser() {

          return userRepository.findAll();
     }

     public User createUser(User newUser) {
          return userRepository.save(newUser);
     }

     public Optional<User> findUserById(Long id) {
          return userRepository.findById(id);
     }

     public List<User> getListLimit(int limit)  {
          
               System.out.println(limit);
               return userRepository.findAll().subList(1,limit);
              
     }
}
