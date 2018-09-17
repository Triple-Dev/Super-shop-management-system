package com.example.demo.repository;

import com.example.demo.Model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier,Long> {
    Supplier findBySupplierName(String supplierName);

    void deleteBySupplierName(String name);
}
