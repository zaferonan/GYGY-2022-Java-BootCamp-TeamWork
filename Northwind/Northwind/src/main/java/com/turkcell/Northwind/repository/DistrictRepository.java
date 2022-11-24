package com.turkcell.Northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

}
