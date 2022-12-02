package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.Northwind.service.dtos.City.CityDto;
import com.turkcell.Northwind.service.dtos.City.ListCityDto;

public interface CityService {

	public ResponseEntity<List<ListCityDto>> getAll();
	public ResponseEntity<CityDto> getById(int cityId);
	public void checkCityId(int cityId);
}
