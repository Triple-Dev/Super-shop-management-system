package com.example.demo.repository;

import com.example.demo.Model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepo extends CrudRepository<Phone,Long> {
}
