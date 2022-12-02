package com.turkcell.Northwind.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.Northwind.DAO.CityDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.City;
import com.turkcell.Northwind.service.abstracts.CityService;
import com.turkcell.Northwind.service.dtos.City.CityDto;
import com.turkcell.Northwind.service.dtos.City.ListCityDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityManager implements CityService{
	
	
	private CityDao cityDao;

	@Override
	public ResponseEntity<List<ListCityDto>> getAll() {
		List<City> cities = cityDao.findAll();
		List<ListCityDto> listCityDtos = new ArrayList<ListCityDto>();
		for (City city : cities) {
			ListCityDto listCityDto = new ListCityDto(city.getId(), city.getCityName());
			listCityDtos.add(listCityDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listCityDtos);
	}

	@Override
	public ResponseEntity<CityDto> getById(int cityId) {
		checkCityId(cityId);
		City city = cityDao.findById(cityId).get();
		CityDto cityDto = new CityDto(city.getId(), city.getCityName(), city.getTowns());
		return ResponseEntity.status(HttpStatus.OK).body(cityDto);
	}

	
	public void checkCityId(int cityId) {
		if (!cityDao.existsById(cityId)) {
			throw new BusinessException("There is no City with this id: " + cityId);
		}
	}
	
}
