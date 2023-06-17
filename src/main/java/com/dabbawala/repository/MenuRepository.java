package com.dabbawala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{
    
}
