package com.turkcell.Northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {

}
