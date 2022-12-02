package com.turkcell.Northwind.service.requests.create;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.turkcell.Northwind.model.IndividualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreateIndividualCustomerRequest extends CreateUserRequest {

	@NotBlank
	@Size(min = 1, max = 100)
	private String nameSurname;

	@Size(min = 1, max = 1)
	private String gender;

	private LocalDate birthDate;

	@Size(min = 11, max = 11)
	private String identityNumber;

	public IndividualCustomer toIndividualCustomer() {

		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.setUserName(this.getUserName());
		individualCustomer.setPassword(this.getPassword());
		individualCustomer.setEmail(this.getEmail());
		individualCustomer.setPhoneNumber(this.getPhoneNumber());
		individualCustomer.setCreatedDate(LocalDate.now());
		individualCustomer.setNameSurname(this.getNameSurname());
		individualCustomer.setGender(this.getGender());
		individualCustomer.setBirthDate(this.getBirthDate());
		individualCustomer.setIdentityNumber(this.getIdentityNumber());

		return individualCustomer;

	}
}
