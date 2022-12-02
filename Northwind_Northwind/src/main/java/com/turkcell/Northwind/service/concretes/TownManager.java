package com.turkcell.Northwind.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.Northwind.DAO.TownDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.Town;
import com.turkcell.Northwind.service.dtos.Town.TownDto;

import lombok.AllArgsConstructor;

import com.turkcell.Northwind.service.abstracts.TownService;
import com.turkcell.Northwind.service.dtos.Town.ListTownDto;

@Service
@AllArgsConstructor
public class TownManager implements TownService{

	private TownDao townDao;

	@Override
	public ResponseEntity<List<ListTownDto>> getAll() {
		List<Town> cities = townDao.findAll();
		List<ListTownDto> listTownDtos = new ArrayList<ListTownDto>();
		for (Town town : cities) {
			ListTownDto listTownDto = new ListTownDto(town.getId(), town.getTownName(), town.getCity());
			listTownDtos.add(listTownDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listTownDtos);
	}

	@Override
	public ResponseEntity<TownDto> getById(int townId) {
		checkTownId(townId);
		Town town = townDao.findById(townId).get();
		TownDto townDto = new TownDto(town.getId(), town.getTownName(), town.getCity());
		return ResponseEntity.status(HttpStatus.OK).body(townDto);
	}

	
	public void checkTownId(int townId) {
		if (!townDao.existsById(townId)) {
			throw new BusinessException("There is no Town with this id: " + townId);
		}
	}
}
