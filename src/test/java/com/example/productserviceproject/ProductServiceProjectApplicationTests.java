package com.example.productserviceproject;

import com.example.productserviceproject.models.Product;
import com.example.productserviceproject.repositories.ProductRepository;
import com.example.productserviceproject.repositories.Projections.ProductWithidAndTitle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;


import java.util.List;

@SpringBootTest
class ProductServiceProjectApplicationTests {

    @Autowired
        private ProductRepository productRepository;

//        public ProductServiceProjectApplicationTests(ProductRepository productRepository) {
//            this.productRepository = productRepository;
//        }
    @Test
    void contextLoads() {
    }
    @Test
    @Transactional

//when we are running a query as a part of Test cases,it automatically rolls that back so that the database state is not changed
//if we dont want spring to automatically rollback the query we annotate it with @commit
    @Commit
    void testQueries() {
        //Derived Query Test
        productRepository.findByTitleContaining("naman");
        //productRepository.deleteByTitleIgnoreCase("naman");

        //Testing a query type
        List<Product> products=productRepository.SomeTask();

        //HQL Projections

        //using parameter type method - no projection used
        List<Product> pro=productRepository.somethingsomething1(7L);

        //No parameter used in method but checking HQL type with projection type(having interface as Datatype)
        List<ProductWithidAndTitle> products1=productRepository.somethingsomething();
        for(ProductWithidAndTitle p:products1){
            System.out.println(p.getId());
            System.out.println(p.getTitle());
        }

        // Native Query Test
        List<Product> products2=productRepository.nativeQTest();
    }

}
