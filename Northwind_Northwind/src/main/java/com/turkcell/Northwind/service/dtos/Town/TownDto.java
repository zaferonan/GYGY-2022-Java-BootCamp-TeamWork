package com.turkcell.Northwind.service.dtos.Town;

import com.turkcell.Northwind.model.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TownDto {

	private int id;
	
	private String townName;

	private City city;
	
}
