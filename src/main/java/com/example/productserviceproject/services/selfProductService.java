package com.example.productserviceproject.services;

import com.example.productserviceproject.Exceptions.ProductNotExistsException;
import com.example.productserviceproject.models.Product;
import com.example.productserviceproject.repositories.CategoryRepository;
import com.example.productserviceproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service("selfProductService")
//Hey Spring this is a Special class please ensure that you have created an object of it and put it in the ApplicationContext
//ensure that this class is instantiated and its object is available for injection
public class selfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired//it's a constructor injection, which is a type of dependency injection(Optional)
    public selfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        return null;
    }

    @Override
    public List<Product> getALLProducts() {
        return null;
    }

    @Override
    public Product replaceproduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}