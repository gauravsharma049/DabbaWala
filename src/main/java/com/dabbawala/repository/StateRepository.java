package com.dabbawala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.State;

public interface StateRepository extends JpaRepository<State, Integer>{
    public List<State> findByStateNameContaining(String stateName);
    public State findByStateName(String stateName);
}
