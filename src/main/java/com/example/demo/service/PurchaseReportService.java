package com.example.demo.service;


import com.example.demo.Model.Product;
import com.example.demo.Model.PurchaseProduct;
import com.example.demo.Model.PurchaseReport;
import com.example.demo.Model.Supplier;
import com.example.demo.repository.PurchaseReportRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseReportService {

    private PurchaseReportRepo purchaseReportRepo;
    private ProductService productService;
    private SupplierService supplierService;

    public PurchaseReportService(PurchaseReportRepo purchaseReportRepo,
                                 ProductService productService,
                                 SupplierService supplierService) {
        this.purchaseReportRepo = purchaseReportRepo;
        this.productService=productService;
        this.supplierService=supplierService;
    }

    public PurchaseReport saveReport(PurchaseReport purchaseReport){

        List<PurchaseProduct> purchaseProductList=purchaseReport.getPurchaseProductList();


        double totalPrice=0;
        for(PurchaseProduct pp : purchaseProductList){
            Product product=productService.getproduct(pp.getProductId());
            double discount=product.getDiscountAmount()+((product.getDiscountParsentage()*product.getParchasePrice())/100);
            totalPrice+=(product.getParchasePrice()-discount) * pp.getQuantity();
            product.setQuantity(product.getQuantity()+pp.getQuantity());
            productService.addProduct(product);
        }

        double discount=purchaseReport.getDiscountAmount()+((purchaseReport.getDiscountPersentage() * totalPrice)/100);
        totalPrice-=discount;

        purchaseReport.setTotalCost(totalPrice);
        Supplier supplier=supplierService.getSupplier(purchaseReport.getSupplierName());
        if(supplier!=null){
            supplier.setTotalPaid(supplier.getTotalPaid()+purchaseReport.getPaid());
            supplier.setTotalProductPrice(supplier.getTotalProductPrice()+totalPrice);
            supplier.setDue(supplier.getTotalProductPrice()-supplier.getTotalPaid());

            supplierService.addSupplier(supplier);
        }

        return purchaseReportRepo.save(purchaseReport);
    }

    public PurchaseReport editReport(PurchaseReport purchaseReport){
        List<PurchaseProduct> purchaseProductList=purchaseReport.getPurchaseProductList();

        PurchaseReport previousReport=getReport(purchaseReport.getPurchaseId());
        if(previousReport!=null){
            List<Double> previousQuantities=new ArrayList<>();
            for(PurchaseProduct pp:previousReport.getPurchaseProductList()){
                previousQuantities.add(pp.getQuantity());
            }

            double totalPrice=0;
            int i=0;
            for(PurchaseProduct pp : purchaseProductList){
                Product product=productService.getproduct(pp.getProductId());
                double discount=product.getDiscountAmount()+((product.getDiscountParsentage()*product.getParchasePrice())/100);
                totalPrice+=(product.getParchasePrice()-discount) * pp.getQuantity();

                double diff=previousQuantities.get(i)-pp.getQuantity();
                i++;
                product.setQuantity(product.getQuantity()-diff);
                productService.addProduct(product);

            }

            double discount=purchaseReport.getDiscountAmount()+((purchaseReport.getDiscountPersentage() * totalPrice)/100);
            totalPrice-=discount;

            purchaseReport.setTotalCost(totalPrice);



            Supplier supplier=supplierService.getSupplier(purchaseReport.getSupplierName());

            if(supplier!=null){

                if(!supplier.getSupplierName().equals(previousReport.getSupplierName())){
                    Supplier previousSupplier=supplierService.getSupplier(previousReport.getSupplierName());
                    previousSupplier.setTotalProductPrice(previousSupplier.getTotalProductPrice()-previousReport.getTotalCost());
                    previousSupplier.setTotalPaid(previousSupplier.getTotalPaid()-previousReport.getPaid());
                    previousSupplier.setDue(previousSupplier.getTotalProductPrice()-previousSupplier.getTotalPaid());
                    supplierService.addSupplier(previousSupplier);


                    supplier.setTotalPaid(supplier.getTotalPaid()+purchaseReport.getPaid());
                    supplier.setTotalProductPrice(supplier.getTotalProductPrice()+totalPrice);
                    supplier.setDue(supplier.getTotalProductPrice()-supplier.getTotalPaid());

                    supplierService.addSupplier(supplier);

                }else {

                    double paidDiff = previousReport.getPaid() - purchaseReport.getPaid();
                    double priceDiff = previousReport.getTotalCost() - purchaseReport.getTotalCost();

                    supplier.setTotalPaid(supplier.getTotalPaid() - paidDiff);
                    supplier.setTotalProductPrice(supplier.getTotalProductPrice() - priceDiff);
                    supplier.setDue(supplier.getTotalProductPrice() - supplier.getTotalPaid());

                    supplierService.addSupplier(supplier);
                }
            }
        }



        return purchaseReportRepo.save(purchaseReport);
    }

    public Iterable<PurchaseReport> getAllReports() {
        return purchaseReportRepo.findAll();
    }

    public PurchaseReport getReport(long purchaseId) {
        return purchaseReportRepo.findById(purchaseId).orElse(null);
    }


}
