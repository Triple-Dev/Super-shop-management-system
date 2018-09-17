package com.example.demo.service;

import com.example.demo.Model.PurchaseProduct;
import com.example.demo.repository.PurchaseProductRepo;
import org.springframework.stereotype.Service;

@Service
public class PurchaseProductService {

    private PurchaseProductRepo purchaseProductRepo;

    public PurchaseProductService(PurchaseProductRepo purchaseProductRepo) {
        this.purchaseProductRepo = purchaseProductRepo;
    }

    public PurchaseProduct savePurchaseProduct(PurchaseProduct purchaseProduct){
        return purchaseProductRepo.save(purchaseProduct);
    }

    public Iterable<PurchaseProduct> saveAllPurchaseProduct(Iterable<PurchaseProduct> purchaseProducts){
        return purchaseProductRepo.saveAll(purchaseProducts);
    }
}
