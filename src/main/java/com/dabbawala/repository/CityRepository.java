package com.dabbawala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{
    public List<City> findByCityNameContaining(String cityName);
    public City findByCityName(String cityName);
}
