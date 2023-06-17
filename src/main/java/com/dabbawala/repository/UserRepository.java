package com.dabbawala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
