package com.turkcell.Northwind.service.dtos.City;

import java.util.List;

import com.turkcell.Northwind.model.City;
import com.turkcell.Northwind.model.Town;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

	public CityDto(City city) {
	
		this.setCityName(city.getCityName());
		this.setId(city.getId());
		this.setTowns(city.getTowns());
	}
	
	private int id;	


	private String cityName;
	

	private List<Town> towns;
	
}
