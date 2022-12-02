package com.turkcell.Northwind.service.requests.create;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.turkcell.Northwind.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreateEmployeeRequest extends CreateUserRequest {

	@NotNull
	@Size(min = 1, max = 100)	
	private String nameSurname;
	

	@DateTimeFormat
	@Past
	private LocalDate birthDate;
	

	@NotNull
	@NotEmpty
	private String role;	
	
	
	private double wage;
	
	public Employee toEmployee() {
		Employee employee=new Employee();
		employee.setUserName(this.getUserName());
		employee.setPassword(this.getPassword());
		employee.setEmail(this.getEmail());
		employee.setPhoneNumber(this.getPhoneNumber());
		employee.setBirthDate(this.getBirthDate());
		employee.setRole(this.getRole());
		employee.setNameSurname(this.getNameSurname());
		employee.setWage(this.getWage());
		employee.setCreatedDate(LocalDate.now());
		
		return employee;
	}
}
