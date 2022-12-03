package com.turkcell.Northwind.DAO;

import com.turkcell.Northwind.model.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer,Integer> {
    CorporateCustomer findByTaxNumberOrderByTaxNumber(String taxNumber);
    CorporateCustomer findByCorporateNameOrderByCorporateName(String corporateName);
    CorporateCustomer findByEmailOrderByEmail(String email);
    CorporateCustomer findByCorporateNameAndTaxNumber(String CorporateName,String taxNumber);
    boolean existsByCorporateName(String corporateName);
    boolean existsByTaxNumber(String taxNumber);

    boolean existsByEmail(String email);
}
