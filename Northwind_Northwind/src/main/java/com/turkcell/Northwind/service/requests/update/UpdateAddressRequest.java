package com.turkcell.Northwind.service.requests.update;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.turkcell.Northwind.model.Address;
import com.turkcell.Northwind.model.City;
import com.turkcell.Northwind.model.Customer;
import com.turkcell.Northwind.model.Town;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {

	@NotNull
	@NotEmpty
	private Customer customer;
	
	@NotNull
	@NotEmpty
	private City city;
	
	@NotNull
	@NotEmpty
	private Town town;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String postalCode;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String addressText;
	
	public Address toAddress() {
		Address address = new Address();
		
		address.setAddressText(this.getAddressText());
		address.setCity(this.getCity());
		address.setCustomer(this.getCustomer());
		address.setPostalCode(this.getPostalCode());
		address.setTown(this.getTown());
		
		return address;
	}
}
