package com.example.productserviceproject;

import com.example.productserviceproject.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

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
    void testQueries(){
        productRepository.findByTitleContaining("naman");
        //productRepository.deleteByTitleIgnoreCase("naman");
    }

}
