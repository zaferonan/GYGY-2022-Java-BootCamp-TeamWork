package com.turkcell.Northwind.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

}
