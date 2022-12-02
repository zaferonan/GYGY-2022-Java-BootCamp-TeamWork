package com.turkcell.Northwind.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	boolean existsByUserName(String userName);
	Employee getById(int userId);
	Employee getByUserNameIgnoreCase(String userName);
	List<Employee> searchByUserNameContainsIgnoreCase(String userName);
	
	

}
