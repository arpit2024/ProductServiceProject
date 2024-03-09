package com.example.productserviceproject.services;

import com.example.productserviceproject.Exceptions.ProductNotExistsException;
import com.example.productserviceproject.models.Category;
import com.example.productserviceproject.models.Product;
import com.example.productserviceproject.repositories.CategoryRepository;
import com.example.productserviceproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


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

        Optional<Product> productOptional=productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product with id "+id+" does not exists");
        }
        Product product=productOptional.get();
        return product;
    }

    @Override
    public List<Product> getALLProducts() throws ProductNotExistsException {
        Optional<List<Product>> productOptional= Optional.ofNullable(productRepository.findAll());
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException(" No Products exists");
        }
        List<Product> products=productOptional.get();
        return products;
        //return null;
    }

    @Override
    public Product replaceproduct(Long id, Product product){
        Optional<Product> productOptional=productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw new RuntimeException("Product with id "+id+" does not exist");
        }
        Product savedProduct=productOptional.get();
        savedProduct.setTitle(product.getTitle());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setImageUrl(product.getImageUrl());

        return productRepository.save(savedProduct);
    }
    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional=productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw new RuntimeException("Product with id "+id+" does not exists");
        }
        Product savedProduct=productOptional.get();
        if(product.getTitle() != null){
            //so if the title that i have received in the method parameter is not null than,i have to update it.
            savedProduct.setTitle(product.getTitle());
        }
        if(product.getDescription()!= null){
            savedProduct.setDescription(product.getDescription());
        }
        if(product.getPrice()!= null){
            savedProduct.setPrice(product.getPrice());
        }
        if(product.getImageUrl() != null){
            savedProduct.setImageUrl(product.getImageUrl());
        }
        return productRepository.save(savedProduct);
    }
    //Here I have to update the particular fields, so I have to get the product from the database for ID

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        Optional<Category> categoryOptional=categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
            product.setCategory(categoryRepository.save(product.getCategory()));
        }
        else{
            product.setCategory(categoryOptional.get());
        }
        return productRepository.save(product);
    }
}
