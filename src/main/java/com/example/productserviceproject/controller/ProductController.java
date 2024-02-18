package com.example.productserviceproject.controller;

// The Controller will get the request from the user and then call the relevant service
//when it gets the response from service controller will give it back to the user
import com.example.productserviceproject.Exceptions.ProductNotExistsException;
import com.example.productserviceproject.models.Category;
import com.example.productserviceproject.models.Product;
import com.example.productserviceproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.productserviceproject.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
// Making a class Serve API's by putting rest controller Annotation
// Hey Spring this is a special class, in this class i am going to imlpement some API's
//so whenever an API request comes to any path that is there within this method,
// please send the api request to that method

@RequestMapping("/products")
// Adding a common prefix of all of the methods
//RequestMapping annotation is used to map web requests onto specific handler classes / handler methods.
// @RequestMapping can be applied to the controller class as well as methods
    public class ProductController{

    //Need an object of service, But instead of creating an object of FakestoreProductService,
    // i am using dependency injection through constructor
    private ProductService productService;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(@Qualifier("selfProductService")ProductService productService,
                             CategoryRepository categoryRepository){
        this.productService=productService;
        this.categoryRepository = categoryRepository;
    }



/*  Response Entity allows you to put->other data like status of the response. ect
    generally ResponseEntity is recommended from Controller methods-so our controller should not be returning
    just the body of the response but also the status of the response (the return data type of the controller should be response entity).

    ResponseEntity is a generic class, so we need to specify the type of data that we are going to return.
    So in this case, we are going to return a list of products. so we will specify the type as List<Product>

    Along with Response Entity we can send Headers as well.usually we use it when we implement Authentication->we will be sendng some data back as headers. */
    @GetMapping
    public ResponseEntity<List<Product>> getALLProducts() throws ProductNotExistsException {
        ResponseEntity<List<Product>>response =new ResponseEntity<>(
                productService.getALLProducts(), HttpStatus.NOT_FOUND
                // since we have set status as NOT_FOUND, we will get 404 error
        );
        return response;
        //return new ResponseEntity<>(productService.getALLProducts(),HttpStatus.OK);
        //return new ArrayList<>();
        //return productService.getALLProducts();
    }

    @GetMapping("/{id}")

    // both id highlighted in green color should've same name,but parameter-Long- id can be different name
    public Product getsingleProduct(@PathVariable("id") Long id)throws ProductNotExistsException{
        //int x=1/0; written this to check arithmatic exception handler method -
        // Exceptions explaines detail in controlladvice class Notes

        return productService.getSingleProduct(id);
    }

//Typically, when we have to send a lot of parameters in request i.e complete object,
//we can send it in the part of body object/Data
//Using @RequestBody annotation, i will get the parameters/Data in the Body
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
//        Product p=new Product();
//        p.setTitle("A new Product");
//        return p;
        Category category=product.getCategory();
        if(category.getId() != null){
            Category savedCategory=categoryRepository.save(category);//this will return the category that is saved
            product.setCategory(savedCategory);
        }
        return productService.addNewProduct(product);//this will return the product that is saved
/*
So (@RequestBody Product product) in this product there will be a category object, but that category
 may or may-not be saved into the database yet. How will I know if it exists or not by checking if that category has a id or not
    if it doesn't exist than->if(category.getId() != null)
    than first we will save the category and then in a product object we Update it
*/
    }


//Partial Update we use Patch
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
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
