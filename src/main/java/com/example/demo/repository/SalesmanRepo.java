package com.example.demo.repository;

import com.example.demo.Model.Salesman;
import org.springframework.data.repository.CrudRepository;

public interface SalesmanRepo extends CrudRepository<Salesman,Long> {
    Iterable<Salesman> findAllByFirstname(String name);
}
