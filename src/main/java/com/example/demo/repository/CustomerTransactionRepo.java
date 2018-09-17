package com.example.demo.repository;

import com.example.demo.Model.CustomerTransaction;
import org.springframework.data.repository.CrudRepository;

public interface CustomerTransactionRepo extends CrudRepository<CustomerTransaction,Long> {
}
