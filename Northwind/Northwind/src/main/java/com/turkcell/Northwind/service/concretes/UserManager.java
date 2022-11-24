package com.turkcell.Northwind.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.Northwind.model.User;
import com.turkcell.Northwind.repository.UserRepository;
import com.turkcell.Northwind.service.abstracts.UserService;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

	private final UserRepository userRepository;

	@Override
	public ResponseEntity<List<ListUserDto>> getAll() {
		List<User> users = userRepository.findAll();

		List<ListUserDto> listUserDtos = new ArrayList<ListUserDto>();

		for (User user : users) {
			ListUserDto listUserDto=new ListUserDto(user.getId(),user.getUserName(),user.getNameSurname());
			listUserDtos.add(listUserDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listUserDtos);
	}

	@Override
	public ResponseEntity<String> add(User user) {
		if(userRepository.existsByUserName(user.getUserName())) {
			throw new RuntimeException("Username is exists!!");
		}
		userRepository.save(user);
		
		
		 return ResponseEntity.status(HttpStatus.OK).body("Saved");
	}

	@Override
	public ResponseEntity<String> update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> delete(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
