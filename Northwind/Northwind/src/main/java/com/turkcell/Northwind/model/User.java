package com.turkcell.Northwind.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	

	@Column(name = "username")
	private String userName;
	

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
