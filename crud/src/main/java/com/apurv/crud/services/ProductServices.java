package com.apurv.crud.services;

import com.apurv.crud.entity.Product;
import com.apurv.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductServices {
    //service communicates with repo which is why we inject it
    @Autowired
    private ProductRepository repository;
    //POST
    //saving single product
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    //saving a list of product
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }
    //GET
    //getting product by id
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    //getting product by name
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }
    //getting all products
    public List<Product> getProducts() {
        return repository.findAll();
    }
    //DELETE
    //delete product by id
    public String deleteById(int id) {
        repository.deleteById(id);
        return "Product deleted successfully id: "+id;
    }
    //delete by name
    public String deleteByName(String name) {
        repository.deleteProductByName(name);
        return "Product deleted successfully name: "+name;
    }
    //delete all
    public String deleteAll() {
        repository.deleteAll();
        return "All products deleted";
    }
    //PUT
    //update product
    public Product updateProduct(Product product) {
        //we find and copy the existing product and then modify it
        //Note:- id cannot be modified as it is read only
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
