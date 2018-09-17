package com.example.demo.controller;

import com.example.demo.Model.Salesman;
import com.example.demo.service.SalesmanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("salesman")
public class SalesnamController {

    private SalesmanService salesmanService;

    public SalesnamController(SalesmanService salesmanService) {
        this.salesmanService = salesmanService;
    }

    @GetMapping("/")
    @ResponseBody
    public Iterable<Salesman> getAllSalesman(){
        return salesmanService.getAllSalesMan();
    }

    @GetMapping("salesman/{id}")
    @ResponseBody
    public Salesman getSalesman(@PathVariable long id){
        return salesmanService.getSalesMan(id);
    }

    @PostMapping("add")
    @ResponseBody
    public Salesman addSalesman(@RequestBody Salesman salesman){
        return salesmanService.saveSalesman(salesman);
    }

    @PutMapping("edit")
    @ResponseBody
    public Salesman editSalesman(@RequestBody Salesman salesman){
        return salesmanService.saveSalesman(salesman);
    }

    @DeleteMapping("delete")
    @ResponseBody
    public Salesman deleteSalesman(@RequestBody Salesman salesman){
        return salesmanService.delete(salesman);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public Salesman deleteSalesManById(@PathVariable long id){
        return salesmanService.deleteById(id);
    }

    @GetMapping("/{name}")
    @ResponseBody
    public Iterable<Salesman> findByName(@PathVariable String name){
        return salesmanService.getSalesmanByName(name);
    }

}
