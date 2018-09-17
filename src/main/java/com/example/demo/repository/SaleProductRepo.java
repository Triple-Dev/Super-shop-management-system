package com.example.demo.repository;

import com.example.demo.Model.SaleProduct;
import org.springframework.data.repository.CrudRepository;

public interface SaleProductRepo extends CrudRepository<SaleProduct,Long> {
}
