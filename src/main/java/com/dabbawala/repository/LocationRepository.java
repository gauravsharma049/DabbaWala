package com.dabbawala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{
    
}
