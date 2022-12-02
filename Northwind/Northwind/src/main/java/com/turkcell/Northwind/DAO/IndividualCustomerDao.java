package com.turkcell.Northwind.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.Employee;
import com.turkcell.Northwind.model.IndividualCustomer;

@Repository
public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, Integer> {

	boolean existsByUserName(String userName);
	IndividualCustomer getById(int userId);
	IndividualCustomer getByUserNameIgnoreCase(String userName);
	List<IndividualCustomer> searchByUserNameContainsIgnoreCase(String userName);
	
	

}
