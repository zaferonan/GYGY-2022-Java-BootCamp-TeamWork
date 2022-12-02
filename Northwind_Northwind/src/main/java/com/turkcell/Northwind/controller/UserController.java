package com.turkcell.Northwind.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.Northwind.service.abstracts.UserService;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;
import com.turkcell.Northwind.service.dtos.User.UserDto;
import com.turkcell.Northwind.service.requests.create.CreateUserRequest;
import com.turkcell.Northwind.service.requests.update.UpdateUserRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ListUserDto>> getAll() {

		return userService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<String> add(@Valid @RequestBody CreateUserRequest createUserRequest) {

		return userService.add(createUserRequest);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@Valid @RequestParam int userId) {

		return userService.delete(userId);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<UserDto> getById(@Valid @RequestParam int userId) {

		return userService.getById(userId);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateUserRequest updateUserRequest){
		return userService.update(updateUserRequest);
	}
	
	@GetMapping("/searchByName")
	public ResponseEntity<List<ListUserDto>> searchByUserName(String userName){
		return userService.searchByUserName(userName);
	}

}
