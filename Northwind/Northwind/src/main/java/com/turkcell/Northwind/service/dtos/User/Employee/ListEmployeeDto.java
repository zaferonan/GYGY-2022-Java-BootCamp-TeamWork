package com.turkcell.Northwind.service.dtos.User.Employee;

import com.turkcell.Northwind.model.Employee;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ListEmployeeDto extends ListUserDto{

	public ListEmployeeDto(Employee employee) {
		this.setId(employee.getId());
		this.setUserName(employee.getUserName());		
		this.setNameSurname(employee.getNameSurname());
		this.setRole(employee.getRole());
	
	}
	private String nameSurname;
	
	
	private String role;



	
}
