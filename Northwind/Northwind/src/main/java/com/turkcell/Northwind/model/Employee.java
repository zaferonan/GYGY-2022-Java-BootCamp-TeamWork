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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
public class Employee extends User  {


	@Column(name = "name_Surname")
	private String nameSurname;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "role")
	private String role;	
	
	@Column(name = "wage")
	private double wage;
}
