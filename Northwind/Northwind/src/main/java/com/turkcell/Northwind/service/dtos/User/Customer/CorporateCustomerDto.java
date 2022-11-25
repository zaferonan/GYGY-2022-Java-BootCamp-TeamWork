package com.turkcell.Northwind.service.dtos.User.Customer;

import com.turkcell.Northwind.model.Address;
import com.turkcell.Northwind.service.dtos.User.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CorporateCustomerDto extends UserDto {

	private String corporateName;

	private String TaxNumber;
	
	private Address address;
}
