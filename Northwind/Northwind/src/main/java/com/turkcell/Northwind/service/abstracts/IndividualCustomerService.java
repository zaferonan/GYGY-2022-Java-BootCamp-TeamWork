package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.Northwind.service.dtos.User.Customer.IndividualCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Customer.ListIndividualCustomerDto;
import com.turkcell.Northwind.service.requests.create.CreateIndividualCustomerRequest;
import com.turkcell.Northwind.service.requests.update.UpdateIndividualCustomerRequest;

public interface IndividualCustomerService {

	public ResponseEntity<List<ListIndividualCustomerDto>> getAll();
	public ResponseEntity<String> add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
	public ResponseEntity<String> update(UpdateIndividualCustomerRequest	updateIndividualCustomerRequest);
	public ResponseEntity<String> delete(int userId);
	public ResponseEntity<IndividualCustomerDto> getById(int userId);
	public ResponseEntity<List<ListIndividualCustomerDto>> searchByUserName(String userName);
}
