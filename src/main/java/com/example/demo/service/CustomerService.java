package com.example.demo.service;

import com.example.demo.Model.Customer;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.DoesNotExists;
import com.example.demo.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;


    public CustomerService(CustomerRepo customerRepo){
            this.customerRepo=customerRepo;
    }

    public Customer addCustomer(Customer customer){
        Optional<Customer> optionalCustomer=customerRepo.findById(customer.getId());
        if(optionalCustomer.isPresent())
            throw new AlreadyExistException("Customer with Id " + customer.getId() + " is already exists");
        else return customerRepo.save(customer);
    }

    public Iterable<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }


    public Optional<Customer> getCustomerById(long customerId) {
        Optional<Customer> optionalCustomer=customerRepo.findById(customerId);
        if(optionalCustomer.isPresent()) return optionalCustomer;
        else throw new DoesNotExists("Customer whith Id "+customerId+" is not exists");
    }

    public Iterable<Customer> getAllCustomersByName(String name){
        return customerRepo.findAllByFirstname(name);
    }

    public Optional<Customer> deleteCustomer(Customer customer) {
        Optional<Customer> optionalCustomer=customerRepo.findById(customer.getId());
        if(optionalCustomer.isPresent()){
            customerRepo.delete(customer);
            return optionalCustomer;
        }else{
            throw new DoesNotExists("Customer with Id "+customer.getId()+" Does not exists");
        }
    }

    public Optional<Customer> deleteCustomerById(long id) {
        Optional<Customer> optionalCustomer=customerRepo.findById(id);
        if(optionalCustomer.isPresent()){
            customerRepo.deleteById(id);
            return optionalCustomer;
        }else{
            throw new DoesNotExists("Customer with Id "+id+" Does not exists");
        }
    }

    public Iterable<Customer> getCustomerByName(String name) {
        return customerRepo.findAllByFirstname(name);
    }

    public Optional<Customer> updateCustomer(long id, Customer customer) {

        Optional<Customer> optionalCustomer=customerRepo.findById(id);
        if(optionalCustomer.isPresent()){
            customerRepo.save(customer);
            return optionalCustomer;
        }else throw new DoesNotExists("Customer with Id "+id+" Does not exists");


    }
}
