package com.turkcell.Northwind.service.dtos.User;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import com.turkcell.Northwind.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


	
	private String userName;	

	

	private String email;
	

	private LocalDate createdDate;
	

	private String phoneNumber;	


}
