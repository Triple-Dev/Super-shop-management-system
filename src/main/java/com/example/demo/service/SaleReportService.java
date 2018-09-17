package com.example.demo.service;

import com.example.demo.Model.*;
import com.example.demo.repository.SaleReportRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleReportService {

    private SaleReportRepo saleReportRepo;
    private ProductService productService;
    private CustomerService customerService;
    private SalesmanService salesmanService;

    public SaleReportService(SaleReportRepo saleReportRepo,
                             ProductService productService,
                             CustomerService customerService,
                             SalesmanService salesmanService
    ) {
        this.saleReportRepo = saleReportRepo;
        this.productService=productService;
        this.customerService=customerService;
        this.salesmanService=salesmanService;
    }

    public SaleReport saveSaleReport(SaleReport saleReport){
        List<SaleProduct> saleProductList=new ArrayList<>();
        saleProductList=saleReport.getSaleProductList();
        long totalPrice=0;

        for(SaleProduct saleProduct:saleProductList){

            Product product=productService.getproduct(saleProduct.getProductId());
            if(product.getQuantity()<saleProduct.getQuantity()){
                saleProduct.setQuantity(product.getQuantity());
            }

            double discount=product.getDiscountAmount()+((product.getDiscountParsentage() * product.getSalePrice())/100);

            totalPrice+=(product.getSalePrice()-discount) * saleProduct.getQuantity();
            product.setQuantity(product.getQuantity()-saleProduct.getQuantity());
            productService.addProduct(product);

        }
        double discountPers=(totalPrice * saleReport.getDiscountPersentage()) / 100;
        totalPrice-=discountPers;
        totalPrice-=saleReport.getDiscountAmount();


        saleReport.setTotalCost(totalPrice);
        Customer customer=customerService.getCustomerById(saleReport.getCustomerId()).get();
        if(customer!=null){
            customer.setTotalpaid(customer.getTotalpaid()+saleReport.getPaid());
            customer.setTotalPurchased(customer.getTotalPurchased()+totalPrice);
            customer.setBalance((customer.getBalance()+saleReport.getPaid())-totalPrice);
            customerService.addCustomer(customer);
        }

        Salesman salesman=salesmanService.getSalesMan(saleReport.getSalesmanId());
        salesman.setTotalSale(salesman.getTotalSale()+totalPrice);

        salesmanService.saveSalesman(salesman);

        return saleReportRepo.save(saleReport);
    }

    public Iterable<SaleReport> getAllReports() {
        return saleReportRepo.findAll();
    }

    public SaleReport getReport(long id){
        return saleReportRepo.findById(id).orElse(null);
    }
}
