package com.turkcell.Northwind.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.Town;

@Repository
public interface TownDao extends JpaRepository<Town, Integer> {

}
