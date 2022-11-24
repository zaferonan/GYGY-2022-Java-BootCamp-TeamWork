package com.turkcell.Northwind.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.Northwind.model.User;
import com.turkcell.Northwind.service.abstracts.UserService;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListUserDto>> getAll(){
		return userService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody User user){
		System.err.println(user.getNameSurname());
		return userService.add(user);
	}
	
}
