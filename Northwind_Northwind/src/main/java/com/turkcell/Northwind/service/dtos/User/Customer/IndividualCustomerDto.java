package com.turkcell.Northwind.service.dtos.User.Customer;

import java.time.LocalDate;

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

	private String nameSurname;

	private String gender;

	private LocalDate birthDate;

	private String identityNumber;
}
