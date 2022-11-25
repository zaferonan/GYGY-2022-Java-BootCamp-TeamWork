package com.turkcell.Northwind.service.dtos.User.Employee;

import java.time.LocalDate;

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

	
	private String nameSurname;
	
	private LocalDate birthDate;
	
	private String role;
	
	private double wage;
}
