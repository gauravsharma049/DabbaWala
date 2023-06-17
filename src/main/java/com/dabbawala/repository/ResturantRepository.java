package com.dabbawala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.Resturant;

public interface ResturantRepository extends JpaRepository<Resturant, Integer>{
    public Resturant findByResturantId(int resturantId);
    public Resturant findByResturantName(String resturantName);
    public List<Resturant> findByCityCityId(int cityId);
    public List<Resturant> findByCityCityName(String cityName);
    public List<Resturant> findByCityDistrictStateStateName(String stateName);
    public List<Resturant> findByCityDistrictDistrictName(String districtName);
    public List<Resturant> findByCityDistrictStateCountryCountryName(String countryName);
    public List<Resturant> findByResturantNameContaining(String resturantName);
}
