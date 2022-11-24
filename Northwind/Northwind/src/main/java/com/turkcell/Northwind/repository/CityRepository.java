package com.turkcell.Northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
