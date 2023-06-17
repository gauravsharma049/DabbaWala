package com.dabbawala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    public List<Country> findByCountryNameContaining(String countryName);
    public Country findByCountryName(String countryName);
}
