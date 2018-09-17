package com.example.demo.repository;

import com.example.demo.Model.PurchaseProduct;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseProductRepo extends CrudRepository<PurchaseProduct,Long> {
}
