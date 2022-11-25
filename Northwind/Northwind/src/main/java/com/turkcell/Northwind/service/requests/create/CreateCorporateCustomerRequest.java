package com.turkcell.Northwind.service.requests.create;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.turkcell.Northwind.model.CorporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreateCorporateCustomerRequest extends CreateUserRequest {

	@NotBlank
	@Size(min = 1, max = 100)
	private String corporateName;
	
	@Size(min = 10, max = 10)
	private String TaxNumber;
	

	
	public CorporateCustomer toCorporateCustomer() {
		CorporateCustomer corporateCustomer =new CorporateCustomer();
		corporateCustomer.setUserName(this.getUserName());
		corporateCustomer.setPassword(this.getPassword());
		corporateCustomer.setEmail(this.getEmail());
		corporateCustomer.setTaxNumber(this.getTaxNumber());
		corporateCustomer.setCorporateName(this.getCorporateName());
		corporateCustomer.setPhoneNumber(this.getPhoneNumber());
		return corporateCustomer;
		
	}
}
