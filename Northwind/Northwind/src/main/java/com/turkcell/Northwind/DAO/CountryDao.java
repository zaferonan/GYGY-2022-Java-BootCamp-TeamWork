package com.turkcell.Northwind.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.Country;

@Repository
public interface CountryDao extends JpaRepository<Country, Integer> {

}
