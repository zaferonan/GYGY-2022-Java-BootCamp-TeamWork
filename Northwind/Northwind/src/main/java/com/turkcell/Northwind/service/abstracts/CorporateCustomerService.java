package com.turkcell.Northwind.service.abstracts;

import com.turkcell.Northwind.service.dtos.User.Customer.CorporateCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Customer.ListCorporateCustomerDto;
import com.turkcell.Northwind.service.requests.create.CreateCorporateCustomerRequest;
import com.turkcell.Northwind.service.requests.update.UpdateCorporateCustomerRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CorporateCustomerService {
    public ResponseEntity<List<ListCorporateCustomerDto>> getAll();
    public ResponseEntity<String> add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
    public ResponseEntity<String> update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);
    public ResponseEntity<String> delete(int corporateCustomerId);
    public ResponseEntity<CorporateCustomerDto> getById(int corporateCustomerId);
    public ResponseEntity<CorporateCustomerDto> findByTaxNumber(String taxNumber);
    public ResponseEntity<CorporateCustomerDto> findCorporateName(String corporateName);
    public ResponseEntity<CorporateCustomerDto> findByEmail(String email);
    public ResponseEntity<CorporateCustomerDto> findByCorporateNameOrTaxNumber(String corporateName,String taxNumber);

}
