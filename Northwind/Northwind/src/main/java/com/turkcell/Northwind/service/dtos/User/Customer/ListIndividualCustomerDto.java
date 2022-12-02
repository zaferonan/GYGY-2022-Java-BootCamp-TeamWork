package com.turkcell.Northwind.service.dtos.User.Customer;

import com.turkcell.Northwind.model.Employee;
import com.turkcell.Northwind.model.IndividualCustomer;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ListIndividualCustomerDto extends ListUserDto {
	
	public ListIndividualCustomerDto(IndividualCustomer individualCustomer) {
		this.setId(individualCustomer.getId());
		this.setUserName(individualCustomer.getUserName());		
		this.setNameSurname(individualCustomer.getNameSurname());
	
	}

	private String nameSurname;
}
