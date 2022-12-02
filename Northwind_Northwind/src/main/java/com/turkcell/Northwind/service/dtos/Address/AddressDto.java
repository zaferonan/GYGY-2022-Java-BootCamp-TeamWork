package com.turkcell.Northwind.service.dtos.Address;

import com.turkcell.Northwind.model.Address;
import com.turkcell.Northwind.model.City;
import com.turkcell.Northwind.model.Customer;
import com.turkcell.Northwind.model.Town;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddressDto {
	
	public AddressDto(Address address) {
		this.setAddressText(address.getAddressText());
		this.setCity(address.getCity());
		this.setCustomer(address.getCustomer());
		this.setPostalCode(address.getAddressText());
		this.setTown(address.getTown());
	}

	private Customer customer;
	
	private City city;
	
	private Town town;
	
	private String postalCode;
	
	private String addressText;
}
