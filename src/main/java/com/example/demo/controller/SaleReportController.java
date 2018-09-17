package com.example.demo.controller;

import com.example.demo.Model.SaleReport;
import com.example.demo.service.SaleReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("saleProduct")
public class SaleReportController {


    private SaleReportService saleReportService;

    public SaleReportController(SaleReportService saleReportService) {
        this.saleReportService = saleReportService;
    }

    @PostMapping("sale")
    @ResponseBody
    public SaleReport saveReport(@RequestBody SaleReport saleReport){
        return saleReportService.saveSaleReport(saleReport);
    }

    @GetMapping("reports")
    @ResponseBody
    public Iterable<SaleReport> getSaleReports(){
        return saleReportService.getAllReports();
    }


}
