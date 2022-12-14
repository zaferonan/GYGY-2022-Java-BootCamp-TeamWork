package com.turkcell.Northwind.service.dtos.User.Customer;

import com.turkcell.Northwind.model.Address;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;
import com.turkcell.Northwind.service.dtos.User.Employee.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ListCorporateCustomerDto extends ListUserDto{

	private String corporateName;

}
