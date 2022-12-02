package com.turkcell.Northwind.service.requests.update;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.turkcell.Northwind.model.CorporateCustomer;
import com.turkcell.Northwind.model.IndividualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdateIndividualCustomerRequest extends UpdateUserRequest {

	@NotBlank
	@Size(min = 1, max = 100)
	private String nameSurname;

	@Size(min = 1, max = 1)	
	private String gender;
	
	private LocalDate birthDate;

	@Size(min = 11, max = 11)	
	private String identityNumber;
	
	public IndividualCustomer toIndividualCustomer() {
		IndividualCustomer individualCustomer =new IndividualCustomer();
		individualCustomer.setId(this.getUserId());
		individualCustomer.setUserName(this.getUserName());
		individualCustomer.setPassword(this.getPassword());
		individualCustomer.setEmail(this.getEmail());
		individualCustomer.setNameSurname(this.getNameSurname());
		individualCustomer.setGender(this.getGender());
		individualCustomer.setPhoneNumber(this.getPhoneNumber());
		individualCustomer.setBirthDate(this.getBirthDate());
		individualCustomer.setIdentityNumber(this.getIdentityNumber());
		return individualCustomer;
}
}
