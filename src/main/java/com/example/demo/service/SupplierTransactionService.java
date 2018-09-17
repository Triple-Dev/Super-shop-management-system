package com.example.demo.service;

import com.example.demo.Model.Supplier;
import com.example.demo.Model.SupplierTransiction;
import com.example.demo.repository.SupplierRepo;
import com.example.demo.repository.SupplierTransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class SupplierTransactionService {

    private SupplierTransactionRepo supplierTransactionRepo;
    private SupplierService supplierService;

    public SupplierTransactionService(SupplierTransactionRepo supplierTransactionRepo, SupplierService supplierService) {
        this.supplierTransactionRepo = supplierTransactionRepo;
        this.supplierService = supplierService;
    }

    public SupplierTransiction saveSupplierTransiction(SupplierTransiction supplierTransiction){

        Supplier supplier=supplierService.getSupplier(supplierTransiction.getSupplierName());
        if(supplier!=null){
            supplier.setTotalPaid(supplier.getTotalPaid()+supplierTransiction.getPaid());
            supplier.setDue(supplier.getTotalProductPrice()-supplier.getTotalPaid());
            supplierService.addSupplier(supplier);
        }



        return supplierTransactionRepo.save(supplierTransiction);
    }

    public SupplierTransiction getTransaction(long id){
        return supplierTransactionRepo.findById(id).orElse(null);
    }

    public Iterable<SupplierTransiction> getAllTransactions(){
        return supplierTransactionRepo.findAll();
    }

}
