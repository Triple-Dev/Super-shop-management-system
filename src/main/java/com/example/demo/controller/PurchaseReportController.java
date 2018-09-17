package com.example.demo.controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.PurchaseProduct;
import com.example.demo.Model.PurchaseReport;
import com.example.demo.service.ProductService;
import com.example.demo.service.PurchaseProductService;
import com.example.demo.service.PurchaseReportService;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("purchaseReport")
public class PurchaseReportController {

    private PurchaseProductService purchaseProductService;
    private PurchaseReportService purchaseReportService;
    private ProductService productService;

    public PurchaseReportController(PurchaseProductService purchaseProductService, PurchaseReportService purchaseReportService, ProductService productService) {
        this.purchaseProductService = purchaseProductService;
        this.purchaseReportService = purchaseReportService;
        this.productService = productService;
    }

    @GetMapping("reports")
    @ResponseBody
    public Iterable<PurchaseReport> getPurchaseReports(){
        return purchaseReportService.getAllReports();
    }

    @PostMapping("saveReport")
    @ResponseBody
    public PurchaseReport addReport(@RequestBody PurchaseReport purchaseReport){
        return purchaseReportService.saveReport(purchaseReport);
    }

    @PutMapping("editReport")
    @ResponseBody
    public PurchaseReport editReport(@RequestBody PurchaseReport purchaseReport){
        return purchaseReportService.editReport(purchaseReport);
    }

}
