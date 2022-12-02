package com.turkcell.Northwind.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.Northwind.service.abstracts.AddressService;
import com.turkcell.Northwind.service.dtos.Address.AddressDto;
import com.turkcell.Northwind.service.dtos.Address.ListAddressDto;
import com.turkcell.Northwind.service.requests.create.CreateAddressRequest;
import com.turkcell.Northwind.service.requests.update.UpdateAddressRequest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

	@NonNull
	private AddressService addressService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListAddressDto>> getAll(){
		return addressService.getAll();
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest) {
		return addressService.update(updateAddressRequest);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@Valid @RequestBody CreateAddressRequest createAddressRequest){
		return addressService.add(createAddressRequest);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int addressId){
		return addressService.delete(addressId);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<AddressDto> getById(@RequestParam int addressId){
		return addressService.getById(addressId);
	}
}
