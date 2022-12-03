package com.turkcell.Northwind.service.concretes;

import com.turkcell.Northwind.DAO.AddressDao;
import com.turkcell.Northwind.DAO.CorporateCustomerDao;
import com.turkcell.Northwind.core.exceptions.BusinessException;
import com.turkcell.Northwind.model.CorporateCustomer;
import com.turkcell.Northwind.service.abstracts.CorporateCustomerService;
import com.turkcell.Northwind.service.dtos.User.Customer.CorporateCustomerDto;
import com.turkcell.Northwind.service.dtos.User.Customer.ListCorporateCustomerDto;
import com.turkcell.Northwind.service.requests.create.CreateCorporateCustomerRequest;
import com.turkcell.Northwind.service.requests.update.UpdateCorporateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {

    private final CorporateCustomerDao corporateCustomerDao;

    @Override
    public ResponseEntity<List<ListCorporateCustomerDto>> getAll() {
        List<CorporateCustomer> corporateCustomers = this.corporateCustomerDao.findAll();
        List<ListCorporateCustomerDto> lists = new ArrayList<>();
        for (CorporateCustomer customer : corporateCustomers){
            ListCorporateCustomerDto corporateCustomerDto = new ListCorporateCustomerDto();
            corporateCustomerDto.setCorporateName(customer.getCorporateName());
            corporateCustomerDto.setUserName(customer.getUserName());

            lists.add(corporateCustomerDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }

    @Override
    public ResponseEntity<String> add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        checkUserName(createCorporateCustomerRequest.getCorporateName());
        this.corporateCustomerDao.save(createCorporateCustomerRequest.toCorporateCustomer());
        return ResponseEntity.status(HttpStatus.CREATED).body(createCorporateCustomerRequest.
                getCorporateName()+" is Created!!");
    }

    @Override
    public ResponseEntity<String> update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        checkUserId(updateCorporateCustomerRequest.getUserId());
        this.corporateCustomerDao.save(updateCorporateCustomerRequest.toCorporateCustomer());
        return ResponseEntity.status(HttpStatus.CREATED).body(updateCorporateCustomerRequest.
                getCorporateName() +" is Updated!!");
    }

    @Override
    public ResponseEntity<String> delete(int corporateCustomerId) {
        checkUserId(corporateCustomerId);
        this.corporateCustomerDao.deleteById(corporateCustomerId);
        return null;
    }

    @Override
    public ResponseEntity<CorporateCustomerDto> getById(int corporateCustomerId) {
        checkUserId(corporateCustomerId);
        CorporateCustomer corporateCustomer = this.corporateCustomerDao.findById(corporateCustomerId).get();
        CorporateCustomerDto corporateCustomerDto = new CorporateCustomerDto();
        corporateCustomerDto.setCreatedDate(corporateCustomer.getCreatedDate());
        corporateCustomerDto.setAddress(corporateCustomer.getAddress());
        corporateCustomerDto.setEmail(corporateCustomer.getEmail());
        corporateCustomerDto.setTaxNumber(corporateCustomer.getTaxNumber());
        corporateCustomerDto.setUserName(corporateCustomer.getUserName());
        corporateCustomerDto.setPhoneNumber(corporateCustomer.getPhoneNumber());
        corporateCustomerDto.setCorporateName(corporateCustomer.getCorporateName());

        return ResponseEntity.status(HttpStatus.OK).body(corporateCustomerDto);
    }

    @Override
    public ResponseEntity<CorporateCustomerDto> findByTaxNumber(String taxNumber) {
        checkTaxNumber(taxNumber);
        CorporateCustomer corporateCustomer = this.corporateCustomerDao.findByTaxNumberOrderByTaxNumber(taxNumber);
        CorporateCustomerDto corporateCustomerDto = new CorporateCustomerDto();
        corporateCustomerDto.setCorporateName(corporateCustomer.getCorporateName());
        corporateCustomerDto.setEmail(corporateCustomer.getEmail());
        corporateCustomerDto.setPhoneNumber(corporateCustomer.getPhoneNumber());
        corporateCustomerDto.setCreatedDate(corporateCustomer.getCreatedDate());
        corporateCustomerDto.setTaxNumber(corporateCustomer.getTaxNumber());
        corporateCustomerDto.setCorporateName(corporateCustomer.getCorporateName());
        corporateCustomerDto.setUserName(corporateCustomer.getUserName());
        return ResponseEntity.status(HttpStatus.OK).body(corporateCustomerDto);
    }

    @Override
    public ResponseEntity<CorporateCustomerDto> findCorporateName(String corporateName) {
        checkUserName(corporateName);
        CorporateCustomer byCorporateName = this.corporateCustomerDao.findByCorporateNameOrderByCorporateName(corporateName);
        CorporateCustomerDto corporateCustomerDto = new CorporateCustomerDto();
        corporateCustomerDto.setUserName(byCorporateName.getUserName());
        corporateCustomerDto.setEmail(byCorporateName.getEmail());
        corporateCustomerDto.setAddress(byCorporateName.getAddress());
        corporateCustomerDto.setCreatedDate(byCorporateName.getCreatedDate());
        corporateCustomerDto.setAddress(byCorporateName.getAddress());
        corporateCustomerDto.setPhoneNumber(byCorporateName.getPhoneNumber());
        corporateCustomerDto.setCorporateName(byCorporateName.getCorporateName());
        return ResponseEntity.status(HttpStatus.OK).body(corporateCustomerDto);
    }

    @Override
    public ResponseEntity<CorporateCustomerDto> findByEmail(String email) {
        checkEmail(email);
        CorporateCustomer byEmailOrderByEmail = this.corporateCustomerDao.findByEmailOrderByEmail(email);
        CorporateCustomerDto corporateCustomerDto = new CorporateCustomerDto();
        corporateCustomerDto.setUserName(byEmailOrderByEmail.getUserName());
        corporateCustomerDto.setEmail(byEmailOrderByEmail.getEmail());
        corporateCustomerDto.setAddress(byEmailOrderByEmail.getAddress());
        corporateCustomerDto.setCreatedDate(byEmailOrderByEmail.getCreatedDate());
        corporateCustomerDto.setAddress(byEmailOrderByEmail.getAddress());
        corporateCustomerDto.setPhoneNumber(byEmailOrderByEmail.getPhoneNumber());
        corporateCustomerDto.setCorporateName(byEmailOrderByEmail.getCorporateName());
        return ResponseEntity.status(HttpStatus.OK).body(corporateCustomerDto);
    }

    @Override
    public ResponseEntity<CorporateCustomerDto> findByCorporateNameOrTaxNumber(String corporateName, String taxNumber) {
        if (!(corporateCustomerDao.existsByCorporateName(corporateName) ||
                corporateCustomerDao.existsByTaxNumber(taxNumber))){
            throw new BusinessException("There is no record of this tax number: "+
                    taxNumber+" and this corporateName "+ corporateName);
        }
        CorporateCustomer nameAndTaxNumber = this.corporateCustomerDao.
                findByCorporateNameAndTaxNumber(corporateName, taxNumber);
        CorporateCustomerDto corporateCustomerDto = new CorporateCustomerDto();
        corporateCustomerDto.setUserName(nameAndTaxNumber.getUserName());
        corporateCustomerDto.setEmail(nameAndTaxNumber.getEmail());
        corporateCustomerDto.setAddress(nameAndTaxNumber.getAddress());
        corporateCustomerDto.setCreatedDate(nameAndTaxNumber.getCreatedDate());
        corporateCustomerDto.setAddress(nameAndTaxNumber.getAddress());
        corporateCustomerDto.setPhoneNumber(nameAndTaxNumber.getPhoneNumber());
        corporateCustomerDto.setCorporateName(nameAndTaxNumber.getCorporateName());
        return ResponseEntity.status(HttpStatus.OK).body(corporateCustomerDto);
    }

    private void checkUserId(int userId) {
        if (!corporateCustomerDao.existsById(userId)) {
            throw new BusinessException("There is no Corporate Customer with this id: " + userId);
        }
    }

    private void checkTaxNumber(String taxNumber) {
        if (!corporateCustomerDao.existsByTaxNumber(taxNumber)) {
            throw new BusinessException("There is no record of this tax number: " + taxNumber);
        }
    }

    private void checkUserName(String corporateName) {
        if (corporateCustomerDao.existsByCorporateName(corporateName)) {
            throw new BusinessException("This CorporateCustomer is already exists!");
        }
    }
    private void checkEmail(String email) {
        if (corporateCustomerDao.existsByEmail(email)){
            throw new BusinessException("There is no record of this email:" + email);
        }
    }
}
