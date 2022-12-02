package com.turkcell.Northwind.service.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.Northwind.DAO.AddressDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.Address;
import com.turkcell.Northwind.model.City;
import com.turkcell.Northwind.model.Town;
import com.turkcell.Northwind.service.abstracts.AddressService;
import com.turkcell.Northwind.service.abstracts.CityService;
import com.turkcell.Northwind.service.abstracts.CustomerService;
import com.turkcell.Northwind.service.abstracts.TownService;
import com.turkcell.Northwind.service.dtos.Address.AddressDto;
import com.turkcell.Northwind.service.dtos.Address.ListAddressDto;
import com.turkcell.Northwind.service.dtos.City.CityDto;
import com.turkcell.Northwind.service.dtos.Town.TownDto;
import com.turkcell.Northwind.service.requests.create.CreateAddressRequest;
import com.turkcell.Northwind.service.requests.update.UpdateAddressRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService{

	private AddressDao addressDao;
	
	private CustomerService customerService;
	
	private CityService cityService;
	
	private TownService townService;
	
	@Override
	public ResponseEntity<List<ListAddressDto>> getAll() {
		List<Address> addresses = addressDao.findAll();
		List<ListAddressDto> listAddressDtos = new ArrayList<ListAddressDto>();
		for (Address address : addresses) {
			ListAddressDto listAddressDto = new ListAddressDto();
			listAddressDto.setCustomerId(address.getCustomer().getId());
			listAddressDto.setCityName(address.getCity().getCityName());
			listAddressDto.setCustomerName(address.getCustomer().getUserName());
			listAddressDtos.add(listAddressDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listAddressDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateAddressRequest createAddressRequest) {
		customerService.checkCustomerId(createAddressRequest.getUserId());
		cityService.checkCityId(createAddressRequest.getCityId());
		townService.checkTownId(createAddressRequest.getTownId());
		Address address = new Address();
		address.setAddressText(createAddressRequest.getAddressText());
		CityDto cityDto = cityService.getById(createAddressRequest.getCityId()).getBody();
		address.setCity(new City(cityDto.getId(), cityDto.getCityName(), cityDto.getTowns()));
		TownDto townDto = townService.getById(createAddressRequest.getTownId()).getBody();
		address.setTown(new Town(townDto.getId(), townDto.getCity(), townDto.getTownName()));
		address.setCustomer(customerService.getById(createAddressRequest.getUserId()));
		address.setPostalCode(createAddressRequest.getPostalCode());
		addressDao.save(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(address.getCustomer().getUserName() + "'s address is saved.");
	}



	@Override
	public ResponseEntity<String> update(UpdateAddressRequest updateAddressRequest) {
		addressDao.save(updateAddressRequest.toAddress());

		return ResponseEntity.status(HttpStatus.CREATED).body(updateAddressRequest.getCustomer() + "'s address is updated.");
	
	}

	@Override
	public ResponseEntity<String> delete(int addressId) {
		Address address = addressDao.getById(addressId);

		addressDao.deleteById(addressId);

		return ResponseEntity.status(HttpStatus.CREATED).body(address.getCustomer() + "'s address is deleted.");
	
	}

	@Override
	public ResponseEntity<AddressDto> getById(int addressId) {
		Address address = addressDao.getById(addressId);

		AddressDto addressDto = new AddressDto(address);

		return ResponseEntity.status(HttpStatus.OK).body(addressDto);
	}
	}

