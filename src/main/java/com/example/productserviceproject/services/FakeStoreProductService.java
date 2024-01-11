package com.example.productserviceproject.services;

import com.example.productserviceproject.dtos.FakeStoreProductDto;
import com.example.productserviceproject.models.Category;
import com.example.productserviceproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

//This class just calls the API- (Talks to the FakeStore API)

@Service
public class FakeStoreProductService implements ProductService{
//so i need RestTemplate object for this class so i declare it
//But i dont want to create one by using "new" keyword, i want it from Application Context

    private RestTemplate restTemplate;

//so create a constructor   of fakestoreservice for the instance/variable of type RestTemplate
//@Autowired-
    @Autowired
    // The reason i am able to autowire this is, check if ProductService is also a special class->yes,
    // there ia an Annotaion of service/one of the implementation of ProductService is a special class
    // so spring will automatically create an object of that and put it in Application Context.
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
/*
For the Autowired Part- if i want to inject a bean to other class how will i do it?
-> Using Constructor
in this constructor  i will take object of the class i wanted to inject
And i will mark that particular thing with Autowire
 */

/*
    Summarization

    Hey Spring in the fakestoreProductService Class i need an Object of rest Template and i am not going to create an object of it
    Please Autowire the object of RestTemplate yourself,
    how will spring do it.
    spring saved the object of restTemplate in Application Context(App Config class),
    so spring will put below part
        new RestTemplateBuilder().build()
    from class Application Config that it had created at the start of the Application to this particular place in Services-FakeStoreProductService method in class(above)
    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
 */

//----------------------------------------------------------------------------------------------------------------------------------
    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct){
/*
Need of this Method:-
so in below SingleProduct methos i am calling Api details using the FakeStore Dto object for matching/mapping data similar to the JSON(Data pack obtained form the URl)

But our service wants us to return the Product type, so i will have to convert from ProductDto to Product.
so writing this method cto convert it.
 */
        Product product=new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(product.getImageUrl());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }
    @Override
    public Product getSingleProduct(Long id) {
        //Calling 3rd party API through Dto object.
        FakeStoreProductDto productDto = restTemplate.getForObject(
                //Make a get call for below URL to get the response
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class
        );
/*
so below line is trying convert the response obtained by calling the url (with FakeStoreProductDto class object type) and
return the object in the form(product) that we require from the ProductDto type.
(conversion is done by calling by convertFakeStoreProductToProduct method and Dto object is passed in it.- the method implementation details can be seen above, with explanation)
*/
        return convertFakeStoreProductToProduct(productDto);
    }

//    public ArrayList<Product> getALLProducts(){
//        FakeStoreProductDto AllProductDto=restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                FakeStoreProductDto.class
//        );
//
//
//    }
}



