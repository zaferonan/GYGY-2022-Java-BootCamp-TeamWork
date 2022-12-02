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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="towns")
public class Town {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "town_id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private City city;
	
	@Column(name = "town_name")
	private String townName;
	
	
}
