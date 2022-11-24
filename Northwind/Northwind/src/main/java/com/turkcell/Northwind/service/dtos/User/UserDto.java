package com.turkcell.Northwind.service.dtos.User;

import java.time.LocalDate;

import com.turkcell.Northwind.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	
	private String userName;
	

	private String password;
	

	private String nameSurname;
	

	private String email;
	

	private String gender;	
	
	
	private LocalDate birthDate;
	

	private LocalDate createdDate;
	

	private String phoneNumber1;
	

	private String phoneNumber2;

	private Address address;
}
