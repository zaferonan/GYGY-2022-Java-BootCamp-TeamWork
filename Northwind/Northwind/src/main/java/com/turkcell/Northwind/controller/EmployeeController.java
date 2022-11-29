package com.turkcell.Northwind.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.Northwind.service.abstracts.EmployeeService;
import com.turkcell.Northwind.service.dtos.User.Employee.EmployeeDto;
import com.turkcell.Northwind.service.dtos.User.Employee.ListEmployeeDto;
import com.turkcell.Northwind.service.requests.create.CreateEmployeeRequest;
import com.turkcell.Northwind.service.requests.update.UpdateEmployeeRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListEmployeeDto>> getAll(){
		return employeeService.getAll();
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		return employeeService.update(updateEmployeeRequest);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest){
		return employeeService.add(createEmployeeRequest);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int userId){
		return employeeService.delete(userId);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<EmployeeDto> getById(@RequestParam int userId){
		return employeeService.getById(userId);
	}
	
	@GetMapping("/getByUserName")
	public ResponseEntity<List<ListEmployeeDto>> searchByUserName(String userName){
		return employeeService.searchByUserName(userName);
	}
}
