package com.turkcell.Northwind.service.dtos.User.Customer;

import java.time.LocalDate;

import com.turkcell.Northwind.model.IndividualCustomer;
import com.turkcell.Northwind.service.dtos.User.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IndividualCustomerDto extends UserDto {
	
	public IndividualCustomerDto(IndividualCustomer individualCustomer) {
		this.setUserName(individualCustomer.getUserName());	
		this.setNameSurname(individualCustomer.getNameSurname());
		this.setIdentityNumber(individualCustomer.getIdentityNumber());
		this.setEmail(individualCustomer.getEmail());
		this.setPhoneNumber(individualCustomer.getPhoneNumber());
		this.setCreatedDate(individualCustomer.getCreatedDate());
		this.setBirthDate(individualCustomer.getBirthDate());				
		this.setGender(individualCustomer.getGender());
	
	}

	private String nameSurname;

	private String gender;

	private LocalDate birthDate;

	private String identityNumber;
}
