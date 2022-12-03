package com.turkcell.Northwind.controller;

import com.turkcell.Northwind.service.abstracts.CorporateCustomerService;
import com.turkcell.Northwind.service.dtos.User.Customer.CorporateCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Customer.ListCorporateCustomerDto;
import com.turkcell.Northwind.service.requests.create.CreateCorporateCustomerRequest;
import com.turkcell.Northwind.service.requests.update.UpdateCorporateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CorporateCustomersController {

    private final CorporateCustomerService corporateCustomerService;

    public ResponseEntity<List<ListCorporateCustomerDto>> getAll(){
        return this.corporateCustomerService.getAll();
    }
    public ResponseEntity<String> add(CreateCorporateCustomerRequest createCorporateCustomerRequest){
        return this.corporateCustomerService.add(createCorporateCustomerRequest);
    }
    public ResponseEntity<String> update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest){
        return this.corporateCustomerService.update(updateCorporateCustomerRequest);
    }
    public ResponseEntity<String> delete(int corporateCustomerId){
        return this.corporateCustomerService.delete(corporateCustomerId);
    }
    public ResponseEntity<CorporateCustomerDto> getById(int corporateCustomerId){
        return this.corporateCustomerService.getById(corporateCustomerId);
    }
    public ResponseEntity<CorporateCustomerDto> findByTaxNumber(String taxNumber){
        return this.corporateCustomerService.findByTaxNumber(taxNumber);
    }
    public ResponseEntity<CorporateCustomerDto> findCorporateName(String corporateName){
        return this.corporateCustomerService.findCorporateName(corporateName);
    }
    public ResponseEntity<CorporateCustomerDto> findByEmail(String email){
        return this.corporateCustomerService.findByEmail(email);
    }
    public ResponseEntity<CorporateCustomerDto>
    findByCorporateNameOrTaxNumber(String corporateName,String taxNumber){
        return this.corporateCustomerService.findByCorporateNameOrTaxNumber(corporateName, taxNumber);
    }
}
