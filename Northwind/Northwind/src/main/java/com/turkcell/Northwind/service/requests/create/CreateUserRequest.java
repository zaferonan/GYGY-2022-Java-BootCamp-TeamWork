package com.turkcell.Northwind.service.requests.create;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.turkcell.Northwind.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {


	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	
	@NotBlank
	@Size(min = 1, max = 50)
	private String password;
	
	@Email
	@Size(min = 1, max = 100)
	private String email;
	
	@Size(min = 5, max = 15)
	private String phoneNumber;
	
	public User toUser() {
		LocalDate date = LocalDate.now();
		User user =new User();
		user.setUserName(this.getUserName());
		user.setPassword(this.getPassword());
		user.setEmail(this.getEmail());
		user.setPhoneNumber(this.getPhoneNumber());
		user.setCreatedDate(date);
		return user;
		
	}
}
