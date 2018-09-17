package com.example.demo.repository;

import com.example.demo.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo  extends CrudRepository<Customer,Long> {
    Iterable<Customer> findAllByFirstname(String name);
}
