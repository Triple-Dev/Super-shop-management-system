package com.example.demo.service;

import com.example.demo.Model.Catagory;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.DoesNotExists;
import com.example.demo.repository.CatagoryRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatagoryService {

    private CatagoryRepo catagoryRepo;

    public CatagoryService(CatagoryRepo catagoryRepo) {
        this.catagoryRepo = catagoryRepo;
    }

    public Catagory addCatagory(Catagory catagory){

        Optional<Catagory> optionalCatagory=catagoryRepo.findById(catagory.getId());

        if(optionalCatagory.isPresent()){
            throw new AlreadyExistException("Catagory with id "+catagory.getId()+" is already exists");
        }else{
            return catagoryRepo.save(catagory);
        }


    }

    public Iterable<Catagory> getAllCatagory(){
        return catagoryRepo.findAll();
    }

    public Optional<Catagory> getCatagoryById(int id){
        Optional<Catagory> optionalCatagory=catagoryRepo.findById(id);
        if(optionalCatagory.isPresent()){
            return optionalCatagory;
        }else{
            throw new DoesNotExists("Catagory with Id "+id+" is not exists");
        }
    }

    public Optional<Catagory> deleteCatagory(Catagory catagory){
        Optional<Catagory> optionalCatagory=catagoryRepo.findById(catagory.getId());
        if(optionalCatagory.isPresent()){
            catagoryRepo.delete(catagory);
            return optionalCatagory;
        }else{
            throw new DoesNotExists("Catagory with Id "+catagory.getId()+" is not exists");
        }
     }

    public Optional<Catagory> deleteCatagoryById(int id){
        Optional<Catagory> optionalCatagory=catagoryRepo.findById(id);
        if(optionalCatagory.isPresent()){
            catagoryRepo.deleteById(id);
            return optionalCatagory;
        }else{
            throw new DoesNotExists("Catagory with Id "+id+" is not exists");
        }
    }

}
