package com.turkcell.Northwind.service.dtos.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUserDto {

	private int id;	

	private String userName;	

	private String nameSurname;
	

}
