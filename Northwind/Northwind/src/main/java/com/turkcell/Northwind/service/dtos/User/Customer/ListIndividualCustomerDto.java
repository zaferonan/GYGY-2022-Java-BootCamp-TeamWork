package com.turkcell.Northwind.service.dtos.User.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ListIndividualCustomerDto {

	private String nameSurname;
}
