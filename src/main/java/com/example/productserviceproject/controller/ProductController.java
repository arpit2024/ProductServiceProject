package com.example.productserviceproject.controller;

// Controller will get the request from the user and then call th e relevant service
//when it get the response from service controller will give it back to user
import com.example.productserviceproject.models.Product;
import com.example.productserviceproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
// Making a class Serve API's by putting rest controller Annotation
// Hey Spring this is a special class, in this class i am going to imlpement some API's
//so whenever an API request come to any path that is there within this method,
// please send the api request to that method

@RequestMapping("/products")
// Adding a common prefix of all of the methods
//RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
// @RequestMapping can be applied to the controller class as well as methods
    public class ProductController{

    //Need an object of service, But instead of creating an object of FakestoreProductService
    // i am using dependency injection through constructor
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public ArrayList<Product> getALLProducts(){
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    // both id highlighted in green color should of same name,but parameter Long- id can be different name
    public Product getsingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

//Typically when we have to send lotof parameters in request i.e complete object
//we can send it in the part of body object/Data
//Using @RequestBody annotation i will get the parameters/Data in the Body
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        Product p=new Product();
        p.setTitle("A new Product");
        return p;
    }

    // Partial Update we use Patch
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return new Product();
    }

//For complete Update we use Put
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }

}
