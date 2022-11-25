package com.turkcell.Northwind.service.requests.create;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
}
