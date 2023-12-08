package com.apurv.crud.repository;

import com.apurv.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    void deleteProductByName(String name);
}
