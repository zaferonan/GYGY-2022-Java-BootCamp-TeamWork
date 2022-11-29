package com.turkcell.Northwind.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	

	@Column(name = "username",unique = true)
	private String userName;
	
	@Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Flag.UNICODE_CASE)
	@Column(name = "password")
	private String password;
	
	@Email
	@Column(name = "email")
	private String email;
	

	@CreatedDate
	@Column(name = "created_date")
	private LocalDate createdDate;
	

	@Column(name = "phone_number")
	private String phoneNumber;	

	
}
