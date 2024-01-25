package com.example.productserviceproject.services;
import com.example.productserviceproject.Exceptions.ProductNotExistsException;
import com.example.productserviceproject.models.Product;

import java.util.ArrayList;
import java.util.List;
//Service should be an interface
// so AsofNow we will be implementing the product service by calling a third Party API
// Later we re-implemet the product service- it will work by our own database
// hence we need interface to implent different Parts as Service
public interface ProductService {


    Product getSingleProduct(Long id) throws ProductNotExistsException;

    List<Product> getALLProducts();

    Product replaceproduct(Long id, Product product);

    Product updateProduct(Long id, Product product);


}
/*
any class implementing ProductService should provide functionality to retrieve
a single product by its ID.
 */