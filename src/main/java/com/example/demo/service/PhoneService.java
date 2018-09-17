package com.example.demo.service;


import com.example.demo.Model.Phone;
import com.example.demo.repository.PhoneRepo;
import org.springframework.stereotype.Service;


@Service
public class PhoneService {

    private PhoneRepo phoneRepo;

    public PhoneService(PhoneRepo phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    public Phone savePhone(Phone phone){
        return phoneRepo.save(phone);
    }
}
