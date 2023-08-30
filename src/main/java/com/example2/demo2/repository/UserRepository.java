package com.example2.demo2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example2.demo2.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
     
}
