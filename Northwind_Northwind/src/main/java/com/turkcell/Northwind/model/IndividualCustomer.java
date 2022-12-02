package com.turkcell.Northwind.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "individual_customers")
public class IndividualCustomer extends Customer {

	
	@Column(name = "name_surname")
	private String nameSurname;
	
	

	@Column(name = "gender")
	private String gender;
	
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	

	@Column(name="identity_number")
	private String identityNumber;
}
