package com.turkcell.Northwind.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.turkcell.Northwind.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	 
}
