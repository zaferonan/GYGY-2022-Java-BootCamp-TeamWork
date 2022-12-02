package com.turkcell.Northwind.service.requests.create;

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
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {

	@NotNull
	private int userId;
	
	@NotNull
	private int cityId;
	
	@NotNull
	private int townId;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String postalCode;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String addressText;
	

}
