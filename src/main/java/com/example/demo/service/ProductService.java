package com.example.demo.service;

import com.example.demo.Model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    public Iterable<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getproduct(long id){
        return productRepo.findById(id).orElse(null);
    }
    public Iterable<Product> getAllByProductGroup(String group){
        return productRepo.findAllByProductGroup(group);
    }
    public Iterable<Product> getAllByProductName(String name){
        return productRepo.findAllByName(name);
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public Product deleteProduct(Product product){
        productRepo.delete(product);
        return product;
    }

    public void deleteProductById(long id){
        productRepo.deleteById(id);
    }

    public void deleteAllProductById(Iterable<Long> idList){
        idList.forEach(i->productRepo.deleteById(i));
    }


    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
}
