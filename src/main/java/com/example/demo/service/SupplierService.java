package com.example.demo.service;


import com.example.demo.Model.Supplier;
import com.example.demo.repository.SupplierRepo;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    private SupplierRepo supplierRepo;

    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public Supplier getSupplier(String name){
        return supplierRepo.findBySupplierName(name);
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public Iterable<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    public Supplier getSuppliersByName(String name) {

        return supplierRepo.findBySupplierName(name);

    }

    public Supplier getSuppliersByid(long id) {
        return supplierRepo.findById(id).orElse(null);
    }

    public Supplier deleteSupplier(Supplier supplier) {
        supplierRepo.delete(supplier);
        return supplier;
    }

    public Supplier deleteSupplierByName(String name) {
        Supplier supplier=supplierRepo.findBySupplierName(name);
        supplierRepo.deleteBySupplierName(name);
        return supplier;
    }
}
