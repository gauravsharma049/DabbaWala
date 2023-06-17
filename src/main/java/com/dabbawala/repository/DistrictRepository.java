package com.dabbawala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabbawala.model.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{
    public List<District> findByDistrictNameContaining(String districtName);
    public District findByDistrictName(String districtName);
}
