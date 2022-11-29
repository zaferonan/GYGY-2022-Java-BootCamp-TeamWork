package com.turkcell.Northwind.service.dtos.User.Employee;

import java.time.LocalDate;

import com.turkcell.Northwind.model.Employee;
import com.turkcell.Northwind.service.dtos.User.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EmployeeDto extends UserDto{

	public EmployeeDto(Employee employee) {
		this.setUserName(employee.getUserName());		
		this.setEmail(employee.getEmail());
		this.setPhoneNumber(employee.getPhoneNumber());
		this.setCreatedDate(employee.getCreatedDate());
		this.setBirthDate(employee.getBirthDate());
		this.setNameSurname(employee.getNameSurname());
		this.setRole(employee.getRole());
		this.setWage(employee.getWage());
	}
	
	private String nameSurname;
	
	private LocalDate birthDate;
	
	private String role;
	
	private double wage;
}
