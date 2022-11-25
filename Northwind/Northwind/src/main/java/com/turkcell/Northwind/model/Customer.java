package com.turkcell.Northwind.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends User {

	@OneToOne(mappedBy = "customer")
	private Address address;
	
	/*
	 * @OneToMany(mappedBy = "customer") private List<Order> orders;
	 */
}
