package com.example.demo.controller;

import com.example.demo.Model.Supplier;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("supplier")
public class supplierController {

    private SupplierService supplierService;

    public supplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/")
    @ResponseBody
    public Iterable<Supplier> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{name}")
    @ResponseBody
    public Supplier getSuppliersByName(@PathVariable String name){
        return supplierService.getSuppliersByName(name);
    }

    @DeleteMapping("delete")
    @ResponseBody
    public Supplier deleteSupplier(@RequestBody Supplier supplier){
        return supplierService.deleteSupplier(supplier);
    }

    @DeleteMapping("delete/{name}")
    @ResponseBody
    public Supplier deleteSupplierByName(@PathVariable String name){
        return supplierService.deleteSupplierByName(name);
    }

    @PutMapping("edit")
    @ResponseBody
    public Supplier editSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }







}
