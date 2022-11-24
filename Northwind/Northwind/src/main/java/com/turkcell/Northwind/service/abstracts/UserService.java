package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.Northwind.model.User;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;

public interface UserService {

	public ResponseEntity<List<ListUserDto>> getAll();
	public ResponseEntity<String> add(User user);
	public ResponseEntity<String> update(User user);
	public ResponseEntity<String> delete(int userId);
	public User getById(int userId);
}
