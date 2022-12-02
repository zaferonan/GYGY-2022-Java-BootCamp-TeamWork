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
import com.turkcell.Northwind.service.abstracts.IndividualCustomerService;
import com.turkcell.Northwind.service.dtos.User.Customer.IndividualCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Customer.ListIndividualCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Employee.EmployeeDto;
import com.turkcell.Northwind.service.dtos.User.Employee.ListEmployeeDto;
import com.turkcell.Northwind.service.requests.create.CreateEmployeeRequest;
import com.turkcell.Northwind.service.requests.create.CreateIndividualCustomerRequest;
import com.turkcell.Northwind.service.requests.update.UpdateEmployeeRequest;
import com.turkcell.Northwind.service.requests.update.UpdateIndividualCustomerRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/individualCustomer")
@AllArgsConstructor
public class IndividualCustomerController {

	
	private IndividualCustomerService individualCustomerService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListIndividualCustomerDto>> getAll(){
		return individualCustomerService.getAll();
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		return individualCustomerService.update(updateIndividualCustomerRequest);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest){
		return individualCustomerService.add(createIndividualCustomerRequest);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int userId){
		return individualCustomerService.delete(userId);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<IndividualCustomerDto> getById(@RequestParam int userId){
		return individualCustomerService.getById(userId);
	}
	
	@GetMapping("/getByUserName")
	public ResponseEntity<List<ListIndividualCustomerDto>> searchByUserName(String userName){
		return individualCustomerService.searchByUserName(userName);
	}
}
