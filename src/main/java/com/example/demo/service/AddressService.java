package com.example.demo.service;

import com.example.demo.Model.Address;
import com.example.demo.repository.AddressRepo;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Address saveAddress(Address address){
        return addressRepo.save(address);

    }
}
