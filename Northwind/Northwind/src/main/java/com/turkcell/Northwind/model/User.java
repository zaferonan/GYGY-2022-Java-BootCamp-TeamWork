package com.turkcell.Northwind.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	@Size(min = 1, max = 50)
	@Column(name = "username")
	private String userName;
	
	@Size(min = 1, max = 50)
	@Column(name = "password")
	private String password;
	
	@Size(min = 1, max = 100)
	@Column(name = "nameSurname")
	private String nameSurname;
	
	@Email
	@Size(min = 1, max = 100)
	@Column(name = "email")
	private String email;
	
	@Size(min = 1, max = 1)
	@Column(name = "gender")
	private String gender;
	
	
	@Column(name = "birthDate")
	private LocalDate birthDate;
	
	@Column(name = "createdDate")
	private LocalDate createdDate;
	
	@Size(min = 15, max = 15)
	@Column(name = "phoneNumber1")
	private String phoneNumber1;
	
	@Size(min = 15, max = 15)
	@Column(name = "phoneNumber2")
	private String phoneNumber2;
	
	@OneToOne()
	@JoinColumn(name = "address_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Address address;
	
}
