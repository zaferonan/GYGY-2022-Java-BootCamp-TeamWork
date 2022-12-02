package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.Northwind.service.dtos.Town.ListTownDto;
import com.turkcell.Northwind.service.dtos.Town.TownDto;

public interface TownService {

	public ResponseEntity<List<ListTownDto>> getAll();
	public ResponseEntity<TownDto> getById(int townId);
	public void checkTownId(int townId);
}
