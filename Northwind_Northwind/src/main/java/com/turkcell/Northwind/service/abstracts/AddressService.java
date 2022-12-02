package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.Northwind.service.dtos.Address.AddressDto;
import com.turkcell.Northwind.service.dtos.Address.ListAddressDto;
import com.turkcell.Northwind.service.requests.create.CreateAddressRequest;
import com.turkcell.Northwind.service.requests.update.UpdateAddressRequest;

public interface AddressService {

	public ResponseEntity<List<ListAddressDto>> getAll();
	public ResponseEntity<String> add(CreateAddressRequest createAddressRequest);
	public ResponseEntity<String> update(UpdateAddressRequest updateAddressRequest);
	public ResponseEntity<String> delete(int addressId);
	public ResponseEntity<AddressDto> getById(int addressId);
	}
