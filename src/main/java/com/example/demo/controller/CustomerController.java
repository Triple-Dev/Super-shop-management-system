package com.example.demo.controller;

import com.example.demo.Model.*;
import com.example.demo.exception.DoesNotExists;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.PhoneRepo;
import com.example.demo.service.AddressService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;
    //private AddressService addressService;
    private PhoneService phoneService;

    public CustomerController(CustomerService customerService,PhoneService phoneService) {
        this.customerService = customerService;
       // this.addressService=addressService;
        this.phoneService=phoneService;
    }

    @PostMapping("add")
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);

    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Customer>> getAllCustomers(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean isValideUser=false;
       // System.out.println("the role is ***** "+principal.getRole());
        for(Object i:(List)principal){
            if(i.toString().equals("ROLE_admin")){
                return ResponseEntity.status(HttpStatus.OK).body((List)customerService.getAllCustomer());
            }
        }

        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(null);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Customer> getByid(@PathVariable long id){

        Optional<Customer> optionalCustomer=customerService.getCustomerById(id);
        if(optionalCustomer.isPresent()){
            ResponseEntity<Customer> customerResponseEntity=ResponseEntity.status(HttpStatus.OK)
                    .body(optionalCustomer.get());

            return customerResponseEntity;
        }else{
            throw new DoesNotExists("Customer whit Id "+id+" does not exists");
        }


    }

    @GetMapping("/{name}")
    @ResponseBody
    public Iterable<Customer> getByName(@PathVariable String name){
        return customerService.getCustomerByName(name);
    }

    @PutMapping("edit/{id}")
    @ResponseBody
    public ResponseEntity<Customer> editCustomer(@PathVariable long id,@RequestBody Customer customer){

        Optional<Customer> optionalCustomer= customerService.updateCustomer(id,customer);
        if(optionalCustomer.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalCustomer.get());
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping("delete")
    @ResponseBody
    public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer){
        Optional<Customer> optionalCustomer= customerService.deleteCustomer(customer);
        if(optionalCustomer.isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(optionalCustomer.get());
        }else return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public Optional<Customer> deleteCustomerById(@PathVariable long id){
        return customerService.deleteCustomerById(id);
    }


}
