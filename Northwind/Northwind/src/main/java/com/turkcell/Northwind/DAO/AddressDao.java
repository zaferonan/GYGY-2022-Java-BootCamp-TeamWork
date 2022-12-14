package com.turkcell.Northwind.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
