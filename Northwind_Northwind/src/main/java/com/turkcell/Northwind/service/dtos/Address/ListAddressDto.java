package com.turkcell.Northwind.service.dtos.Address;

import com.turkcell.Northwind.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAddressDto {
	
	public ListAddressDto(Address address) {
		this.setCustomerId(address.getCustomer().getId());
		this.setCustomerName(address.getCustomer().getUserName());
		this.setCityName(address.getCity().getCityName());
	}

	private int customerId;
	
	private String customerName;
	
	private String cityName;
	

}
