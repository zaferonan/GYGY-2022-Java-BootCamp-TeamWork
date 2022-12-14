package com.turkcell.Northwind.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.Northwind.model.User;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;
import com.turkcell.Northwind.service.dtos.User.UserDto;
import com.turkcell.Northwind.service.requests.create.CreateUserRequest;
import com.turkcell.Northwind.service.requests.update.UpdateUserRequest;

public interface UserService {

	public ResponseEntity<List<ListUserDto>> getAll();
	public ResponseEntity<String> add(CreateUserRequest createUserRequest);
	public ResponseEntity<String> update(UpdateUserRequest	updateUserRequest);
	public ResponseEntity<String> delete(int userId);
	public ResponseEntity<UserDto> getById(int userId);
	public ResponseEntity<List<ListUserDto>> searchByUserName(String userName);
}
