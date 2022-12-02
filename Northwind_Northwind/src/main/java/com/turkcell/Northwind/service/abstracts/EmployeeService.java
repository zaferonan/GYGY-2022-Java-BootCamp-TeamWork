package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.Northwind.service.dtos.User.Employee.EmployeeDto;
import com.turkcell.Northwind.service.dtos.User.Employee.ListEmployeeDto;
import com.turkcell.Northwind.service.requests.create.CreateEmployeeRequest;
import com.turkcell.Northwind.service.requests.update.UpdateEmployeeRequest;

public interface EmployeeService   {

	public ResponseEntity<List<ListEmployeeDto>> getAll();
	public ResponseEntity<String> add(CreateEmployeeRequest createEmployeeRequest);
	public ResponseEntity<String> update(UpdateEmployeeRequest	updateEmployeeRequest);
	public ResponseEntity<String> delete(int userId);
	public ResponseEntity<EmployeeDto> getById(int userId);
	public ResponseEntity<List<ListEmployeeDto>> searchByUserName(String userName);
}
