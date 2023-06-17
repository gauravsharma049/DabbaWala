package com.dabbawala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>{
    public List<Subscription> findByResturantResturantId(int resturantId);
    public List<Subscription> findByUserUserId(int userId);
    public List<Subscription> findByUserUserName(String userName);
}
