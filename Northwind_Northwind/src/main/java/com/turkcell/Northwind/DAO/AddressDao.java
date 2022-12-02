package com.turkcell.Northwind.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.Northwind.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

//	boolean existsByUserAddress(String userAddress);
//	Address getById(int userId);
//	Address getByUserAddressIgnoreCase(String userAddress);
//	List<Address> searchByUserAddressContainsIgnoreCase(String userAddress);
//	
}
