package com.turkcell.Northwind.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.Northwind.DAO.IndividualCustomerDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.Employee;
import com.turkcell.Northwind.model.IndividualCustomer;
import com.turkcell.Northwind.service.abstracts.IndividualCustomerService;
import com.turkcell.Northwind.service.dtos.User.Customer.IndividualCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Customer.ListIndividualCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Employee.EmployeeDto;
import com.turkcell.Northwind.service.dtos.User.Employee.ListEmployeeDto;
import com.turkcell.Northwind.service.requests.create.CreateIndividualCustomerRequest;
import com.turkcell.Northwind.service.requests.update.UpdateIndividualCustomerRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService{


	private IndividualCustomerDao individualCustomerDao;
	
	@Override
	public ResponseEntity<List<ListIndividualCustomerDto>> getAll() {
		List<IndividualCustomer> individualCustomers = individualCustomerDao.findAll(Sort.by(Sort.Direction.ASC, "id"));
		List<ListIndividualCustomerDto> listIndividualCustomerDtos = new ArrayList<ListIndividualCustomerDto>();
		for (IndividualCustomer individualCustomer : individualCustomers) {
			ListIndividualCustomerDto listIndividualCustomerDto = new ListIndividualCustomerDto(individualCustomer);

			listIndividualCustomerDtos.add(listIndividualCustomerDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listIndividualCustomerDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		checkUserName(createIndividualCustomerRequest.getUserName());

		individualCustomerDao.save(createIndividualCustomerRequest.toIndividualCustomer());

		return ResponseEntity.status(HttpStatus.CREATED).body(createIndividualCustomerRequest.getNameSurname() + " is saved.");
	}

	@Override
	public ResponseEntity<String> update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		checkUserId(updateIndividualCustomerRequest.getUserId());
		individualCustomerDao.save(updateIndividualCustomerRequest.toIndividualCustomer());

		return ResponseEntity.status(HttpStatus.CREATED).body(updateIndividualCustomerRequest.getNameSurname() + " is updated.");
	}

	@Override
	public ResponseEntity<String> delete(int userId) {
		checkUserId(userId);

		IndividualCustomer individualCustomer = individualCustomerDao.getById(userId);

		individualCustomerDao.deleteById(userId);

		return ResponseEntity.status(HttpStatus.CREATED).body(individualCustomer.getNameSurname() + " is deleted.");
	}

	@Override
	public ResponseEntity<IndividualCustomerDto> getById(int userId) {
		checkUserId(userId);

		IndividualCustomer individualCustomer = individualCustomerDao.getById(userId);

		IndividualCustomerDto individualCustomerDto = new IndividualCustomerDto(individualCustomer);

		return ResponseEntity.status(HttpStatus.OK).body(individualCustomerDto);
	}

	@Override
	public ResponseEntity<List<ListIndividualCustomerDto>> searchByUserName(String userName) {
		List<IndividualCustomer> individualCustomers = individualCustomerDao.searchByUserNameContainsIgnoreCase(userName);
		List<ListIndividualCustomerDto> listIndividualCustomerDtos = new ArrayList<ListIndividualCustomerDto>();
		for (IndividualCustomer individualCustomer : individualCustomers) {
			ListIndividualCustomerDto listIndividualCustomerDto = new ListIndividualCustomerDto(individualCustomer);

			listIndividualCustomerDtos.add( listIndividualCustomerDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listIndividualCustomerDtos);
	}
	

	private void checkUserId(int userId) {
		if (!individualCustomerDao.existsById(userId)) {
			throw new BusinessException("There is no User with this id: " + userId);
		}
	}

	private void checkUserName(String userName) {
		if (individualCustomerDao.existsByUserName(userName)) {
			throw new BusinessException("This username is exists!");
		}

	}

}
