package com.turkcell.Northwind.service.requests.update;

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
public class UpdateCorporateCustomerRequest extends UpdateUserRequest {

	@NotBlank
	@Size(min = 1, max = 100)
	private String corporateName;
	
	@Size(min = 10, max = 10)
	private String TaxNumber;
	

	
	public CorporateCustomer toCorporateCustomer() {
		CorporateCustomer corporateCustomer =new CorporateCustomer();
		corporateCustomer.setId(this.getUserId());
		corporateCustomer.setUserName(this.getUserName());
		corporateCustomer.setPassword(this.getPassword());
		corporateCustomer.setEmail(this.getEmail());
		corporateCustomer.setTaxNumber(this.getTaxNumber());
		corporateCustomer.setCorporateName(this.getCorporateName());
		corporateCustomer.setPhoneNumber(this.getPhoneNumber());
		return corporateCustomer;
		
	}
}
