package com.example.demo.repository;

import com.example.demo.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,Long> {
    Iterable<Product> findAllByProductGroup(String group);

    Iterable<Product> findAllByName(String name);
}
