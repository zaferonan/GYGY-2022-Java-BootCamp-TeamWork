package com.turkcell.Northwind.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.Northwind.DAO.EmployeeDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.Employee;
import com.turkcell.Northwind.service.abstracts.EmployeeService;
import com.turkcell.Northwind.service.dtos.User.Employee.EmployeeDto;
import com.turkcell.Northwind.service.dtos.User.Employee.ListEmployeeDto;
import com.turkcell.Northwind.service.requests.create.CreateEmployeeRequest;
import com.turkcell.Northwind.service.requests.update.UpdateEmployeeRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;

	@Override
	public ResponseEntity<List<ListEmployeeDto>> getAll() {
		List<Employee> employees = employeeDao.findAll(Sort.by(Sort.Direction.ASC, "id"));
		List<ListEmployeeDto> listEmployeeDtos = new ArrayList<ListEmployeeDto>();
		for (Employee employee : employees) {
			ListEmployeeDto listEmployeeDto = new ListEmployeeDto(employee);

			listEmployeeDtos.add(listEmployeeDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listEmployeeDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateEmployeeRequest createEmployeeRequest) {

		checkUserName(createEmployeeRequest.getUserName());

		employeeDao.save(createEmployeeRequest.toEmployee());

		return ResponseEntity.status(HttpStatus.CREATED).body(createEmployeeRequest.getNameSurname() + " is saved.");
	}

	@Override
	public ResponseEntity<String> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkUserId(updateEmployeeRequest.getUserId());
		employeeDao.save(updateEmployeeRequest.toEmployee());

		return ResponseEntity.status(HttpStatus.CREATED).body(updateEmployeeRequest.getNameSurname() + " is updated.");
	}

	@Override
	public ResponseEntity<String> delete(int userId) {
		checkUserId(userId);

		Employee employee = employeeDao.getById(userId);

		employeeDao.deleteById(userId);

		return ResponseEntity.status(HttpStatus.CREATED).body(employee.getNameSurname() + " is deleted.");
	}

	@Override
	public ResponseEntity<EmployeeDto> getById(int userId) {
		checkUserId(userId);

		Employee employee = employeeDao.getById(userId);

		EmployeeDto employeeDto = new EmployeeDto(employee);

		return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
	}

	@Override
	public ResponseEntity<List<ListEmployeeDto>> searchByUserName(String userName) {
		List<Employee> employees = employeeDao.searchByUserNameContainsIgnoreCase(userName);
		List<ListEmployeeDto> listEmployeeDtos = new ArrayList<ListEmployeeDto>();
		for (Employee employee : employees) {
			ListEmployeeDto listEmployeeDto = new ListEmployeeDto(employee);

			listEmployeeDtos.add( listEmployeeDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listEmployeeDtos);
	}

	private void checkUserId(int userId) {
		if (!employeeDao.existsById(userId)) {
			throw new BusinessException("There is no User with this id: " + userId);
		}
	}

	private void checkUserName(String userName) {
		if (employeeDao.existsByUserName(userName)) {
			throw new BusinessException("This username is exists!");
		}

	}

}
