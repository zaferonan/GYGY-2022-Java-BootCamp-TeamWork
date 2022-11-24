package com.turkcell.Northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public boolean existsByUserName(String userName);
}
