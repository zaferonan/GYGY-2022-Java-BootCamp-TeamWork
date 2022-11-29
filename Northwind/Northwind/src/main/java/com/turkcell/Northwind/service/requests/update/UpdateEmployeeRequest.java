package com.turkcell.Northwind.service.requests.update;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.turkcell.Northwind.model.Employee;
import com.turkcell.Northwind.service.dtos.User.Employee.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdateEmployeeRequest extends UpdateUserRequest {

	@NotNull
	@Size(min = 1, max = 100)	
	private String nameSurname;
	

	private LocalDate birthDate;
	

	@NotNull
	@NotEmpty
	private String role;	
	

	private double wage;
	
	public Employee toEmployee() {
		Employee employee=new Employee();
		employee.setId(this.getUserId());
		employee.setUserName(this.getUserName());
		employee.setPassword(this.getPassword());
		employee.setEmail(this.getEmail());
		employee.setPhoneNumber(this.getPhoneNumber());
		employee.setBirthDate(this.getBirthDate());
		employee.setRole(this.getRole());
		employee.setNameSurname(this.getNameSurname());
		employee.setWage(this.getWage());
		
		return employee;
	}
}
