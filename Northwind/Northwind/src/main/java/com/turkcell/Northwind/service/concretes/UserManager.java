package com.turkcell.Northwind.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.Northwind.DAO.UserDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.User;
import com.turkcell.Northwind.service.abstracts.UserService;
import com.turkcell.Northwind.service.dtos.User.ListUserDto;
import com.turkcell.Northwind.service.dtos.User.UserDto;
import com.turkcell.Northwind.service.requests.create.CreateUserRequest;
import com.turkcell.Northwind.service.requests.update.UpdateUserRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

	private final UserDao userDao;

	@Override
	public ResponseEntity<List<ListUserDto>> getAll() {
		List<User> users = userDao.findAll();

		List<ListUserDto> listUserDtos = new ArrayList<ListUserDto>();

		for (User user : users) {
			ListUserDto listUserDto = new ListUserDto();
			listUserDto.setId(user.getId());
			listUserDto.setUserName(user.getUserName());

			listUserDtos.add(listUserDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listUserDtos);

	}

	@Override
	public ResponseEntity<String> add(CreateUserRequest createUserRequest) {
		checkUserName(createUserRequest.getUserName());

		userDao.save(createUserRequest.toUser());
		return ResponseEntity.status(HttpStatus.CREATED).body(createUserRequest.getUserName() + " is created.");

	}

	@Override
	public ResponseEntity<String> update(UpdateUserRequest updateUserRequest) {
		checkUserId(updateUserRequest.getUserId());

		userDao.save(updateUserRequest.toUser());

		return ResponseEntity.status(HttpStatus.CREATED).body(updateUserRequest.getUserName() + " is updated.");
	}

	@Override
	public ResponseEntity<String> delete(int userId) {

		checkUserId(userId);

		userDao.deleteById(userId);

		return ResponseEntity.status(HttpStatus.OK).body("User is deleted!");
	}

	@Override
	public ResponseEntity<UserDto> getById(int userId) {

		checkUserId(userId);

		User user = userDao.getById(userId);

		UserDto userDto = new UserDto();
		userDto.setUserName(user.getUserName());		
		userDto.setEmail(user.getEmail());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setCreatedDate(user.getCreatedDate());

		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}

	private void checkUserId(int userId) {
		if (!userDao.existsById(userId)) {
			throw new BusinessException("There is no User with this id: " + userId);
		}
	}

	private void checkUserName(String userName) {
		if (userDao.existsByUserName(userName)) {
			throw new BusinessException("This username is exists!");
		}

	}

	@Override
	public ResponseEntity<List<ListUserDto>> searchByUserName(String userName) {
		List<User> users = userDao.searchByUserNameContainsIgnoreCase(userName);

		List<ListUserDto> listUserDtos = new ArrayList<ListUserDto>();

		for (User user : users) {
			ListUserDto listUserDto = new ListUserDto();
			listUserDto.setId(user.getId());
			listUserDto.setUserName(user.getUserName());

			listUserDtos.add(listUserDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listUserDtos);
	}

}
