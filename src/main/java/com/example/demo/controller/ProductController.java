package com.example.demo.controller;

import com.example.demo.Model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.event.IIOReadProgressListener;

@Controller
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("products")
    @ResponseBody
    Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("productsByGroup/{group}")
    @ResponseBody
    Iterable<Product> getAllByProductGroup(@PathVariable String group){
        return productService.getAllByProductGroup(group);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("productsByName/{name}")
    @ResponseBody
    Iterable<Product> getAllByProductName(@PathVariable String name){
        return productService.getAllByProductName(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("productById/{id}")
    @ResponseBody
    Product getproductById(@PathVariable int id){
        return productService.getproduct(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("deleteProduct")
    @ResponseBody
    Product deleteProduct(@RequestBody Product product){
        return productService.deleteProduct(product);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("deleteProductsById")
    void deleteAllProductbyId(@RequestBody Iterable<Long> idList){
        productService.deleteAllProductById(idList);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("deleteProductById/{id}")
    void deleteProductById(@PathVariable int id){
        productService.deleteProductById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("updateProduct")
    @ResponseBody
    Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("addProduct")
    @ResponseBody
    Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }





}
