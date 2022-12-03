package com.turkcell.Northwind.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "corporate_customers")
public class CorporateCustomer extends Customer {

	
	@Column(name = "corporate_name",unique = true)
	private String corporateName;
	
	
	@Column(name = "tax_number",unique = true)
	private String TaxNumber;
}
