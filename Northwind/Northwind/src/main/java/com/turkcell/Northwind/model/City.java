package com.turkcell.Northwind.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "country_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Country country;
	
	@Size(min=2,max = 50)
	@Column(name = "city_name")
	private String cityName;
	
	@OneToMany(mappedBy = "city")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Town> towns;
	
}
