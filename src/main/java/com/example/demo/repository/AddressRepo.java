package com.example.demo.repository;

import com.example.demo.Model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address,Long> {
}
