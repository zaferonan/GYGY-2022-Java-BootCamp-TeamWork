package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import com.turkcell.Northwind.model.Customer;

public interface CustomerService {

	public List<Customer> getAll();
	public Customer getById(int userId);
	public void checkCustomerId(int customerId);
}
