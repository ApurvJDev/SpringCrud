package com.apurv.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                           // for getter and setter
@NoArgsConstructor              // for empty constructor
@AllArgsConstructor             // for parameterized constructor
@Entity
@Table(name = "Product_Details")
public class Product {
    @Id                          // for primary key
    @GeneratedValue              // to generate random value
    private int id;
    private String name;
    private int quantity;
    private double price;
}
