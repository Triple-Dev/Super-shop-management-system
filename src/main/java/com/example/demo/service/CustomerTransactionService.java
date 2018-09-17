package com.example.demo.service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerTransaction;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.CustomerTransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerTransactionService {

    private CustomerTransactionRepo customerTransactionRepo;
    private CustomerRepo customerRepo;
    public CustomerTransactionService(CustomerTransactionRepo customerTransactionRepo,CustomerRepo customerRepo) {
        this.customerTransactionRepo = customerTransactionRepo;
        this.customerRepo=customerRepo;
    }

    public CustomerTransaction saveTransaction(CustomerTransaction customerTransaction){

        Customer customer=customerRepo.findById(customerTransaction.getCustomerId()).orElse(null);

        if(customer!=null){
            customer.setTotalpaid(customer.getTotalpaid() + customerTransaction.getPaid());
            customer.setBalance(customer.getBalance()+customerTransaction.getPaid());
            customerRepo.save(customer);
        }

        return customerTransactionRepo.save(customerTransaction);
    }
}
