package com.turkcell.Northwind.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	boolean existsByUserName(String userName);

	User getById(int userId);
	

}
