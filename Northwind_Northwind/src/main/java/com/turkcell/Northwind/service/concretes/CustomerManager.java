package com.turkcell.Northwind.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.Northwind.DAO.CustomerDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.Customer;
import com.turkcell.Northwind.service.abstracts.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAll() {
		
		return customerDao.findAll();
	}

	@Override
	public Customer getById(int userId) {
		checkCustomerId(userId);
		
		return customerDao.findById(userId).get();
	}
	
	public void checkCustomerId(int customerId) {
		if (!customerDao.existsById(customerId)) {
			throw new BusinessException("There is no City with this id: " + customerId);
		}
	}

}
