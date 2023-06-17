package com.dabbawala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
    
}
