package com.turkcell.Northwind.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	
	@OneToOne()	
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne()
	@JoinColumn(name = "country_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Country country;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "town_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Town town;
	
	@ManyToOne()
	@JoinColumn(name = "district_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private District district;
	
	@Size(max = 10)
	@Column(name = "postalCode")
	private String postalCode;
	
	@Size(min = 5,max = 500)
	@Column(name = "address_text")
	private String addressText;
	
	
}
