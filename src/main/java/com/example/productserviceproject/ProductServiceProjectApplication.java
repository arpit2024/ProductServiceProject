package com.example.productserviceproject;

import com.example.productserviceproject.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Business logic is present as the part of Service
//Typicalli Service have one on one Mapping with Controller
// For Ex- All of the Services wrt Product, we have them in product service
// All od the services wrt category , we have them in Category services
@SpringBootApplication
public class ProductServiceProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductServiceProjectApplication.class, args);

//        Product pro = new Product();
//        pro.getId();

    }
}

