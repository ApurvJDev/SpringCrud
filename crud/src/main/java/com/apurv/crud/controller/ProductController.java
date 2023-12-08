package com.apurv.crud.controller;

import com.apurv.crud.entity.Product;
import com.apurv.crud.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    //controller communicates with the service class so we inject it
    @Autowired
    ProductServices services;
    //rest end points for all the methods in ProductServices.class
    //POST METHODS
    //saving single product
    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product) {//this annotation is used when we want to retrieve value
        return services.saveProduct(product);
    }
    //saving list of products
    @PostMapping("/saveProducts")
    public List<Product> saveProducts(@RequestBody List<Product> products) {
        return services.saveProducts(products);
    }
    //GET METHODS
    //get product by id
    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable int id) {//this annotation is used when we want to give value in the url
        return services.getProductById(id);
    }
    //get product by name
    @GetMapping("/getProduct/name")
    public Product getProductByName(@PathVariable String name) {
        return services.getProductByName(name);
    }
    //get all product
    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return services.getProducts();
    }
    //DELETE METHODS
    //delete by id
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        return services.deleteById(id);
    }
    //delete by name
    @DeleteMapping("/delete/{name}")
    public String deleteByName(@PathVariable String name) {
        return services.deleteByName(name);
    }
    //delete all
    @DeleteMapping("/deleteAll")
    public String delete() {
        return services.deleteAll();
    }
    //PUT METHODS
    @PutMapping("/updateProduct")
    public Product updateProduct(Product product) {
        return services.updateProduct(product);
    }
}
