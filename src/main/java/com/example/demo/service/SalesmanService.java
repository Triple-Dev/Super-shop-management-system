package com.example.demo.service;

import com.example.demo.Model.Salesman;
import com.example.demo.repository.SalesmanRepo;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService {

    private SalesmanRepo salesmanRepo;

    public SalesmanService(SalesmanRepo salesmanRepo) {
        this.salesmanRepo = salesmanRepo;
    }

    public Salesman getSalesMan(long id){
        return salesmanRepo.findById(id).orElse(null);
    }

    public Iterable<Salesman> getAllSalesMan(){
        return salesmanRepo.findAll();
    }

    public Salesman saveSalesman(Salesman salesman) {
        return salesmanRepo.save(salesman);
    }

    public Salesman delete(Salesman salesman) {
        salesmanRepo.delete(salesman);
        return salesman;
    }

    public Salesman deleteById(long id) {
        Salesman salesman=salesmanRepo.findById(id).orElse(null);
        salesmanRepo.deleteById(id);
        return salesman;
    }

    public Iterable<Salesman> getSalesmanByName(String name) {
        return salesmanRepo.findAllByFirstname(name);
    }
}
