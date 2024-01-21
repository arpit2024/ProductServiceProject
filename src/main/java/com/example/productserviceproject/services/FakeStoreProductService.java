package com.example.productserviceproject.services;

import com.example.productserviceproject.dtos.FakeStoreProductDto;
import com.example.productserviceproject.models.Category;
import com.example.productserviceproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//This class just calls the API- (Talks to the FakeStore API)

@Service
public class FakeStoreProductService implements ProductService{
//so i need RestTemplate object for this class so i declare it
//But i dont want to create one by using "new" keyword, i want it from Application Context

    private RestTemplate restTemplate;

//so create a constructor of fakeStoreService for the instance/variable of type RestTemplate

    @Autowired
    // The reason i am able to autowire this is........check if ProductService is also a special class->if yes,
    // there ia an Annotation of service/one of the implementation of ProductService is a special class than
    // spring will automatically create an object of that and put it in Application Context.
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
/*
For the Autowired Part-if i want to inject a bean to other class how will i do it?
-> Using Constructor
in this constructor  i will take object of the class i wanted to inject
And i will mark that particular thing with Autowire
 */

/*
    Summarization

    Hey Spring in the fakeStoreProductService Class i need an Object of rest Template and i am not going to create an object of it
    Please Autowire the object of RestTemplate yourself,
    how will spring do it.
    spring saved the object of restTemplate in Application Context(App Config class),
    so spring will put below part
        new RestTemplateBuilder().build()
    from class-Application Config that it had created at the start of the Application to this particular place in Services-FakeStoreProductService method in class(above)
    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
 */

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct){
/*
Need of this Method:-
so in below SingleProduct method i am calling Api details using the FakeStore Dto object for matching/mapping data similar to the JSON(Data pack obtained form the URl)

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

    @Override
    public Product replaceproduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        //restTemplate.exchange();
        //we are not using restTemplate.Put() For object because the API is returning us a JSON but
        // put returns a void ,so to avoid that we are using exchange


        //Here we are using one of the methods - public <T> T postForObject from the restTemplate Library body
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFakeStoreProductToProduct(response);
    }


    @Override
    public List<Product> getALLProducts(){
/* Here List Uses Generics
Because of Java Generics(concept- type erasure) we are not able to get the type of the list during Runtime,
    as type erasure erases the data type(fakeStoreDto) after compiling the code.
        "https://fakestoreapi.com/products",
                List<FakeStoreProductDto> response =restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto.class);

so when we put debug point and check-> all the product details were converted to hashmap-But why
Because this info- i.e List of FakesStoreProductDto is not available at runtime, so java(Rest template) internally tries to convert it into HashMap

why HashMap-> what library does is, whatever JSON it gets- it tries to convert that into whatever best possible Object(Key-Value Pair)
For that reason in java similar to List we have array , since we don't have generics issue in Array we can use it.
*/
        FakeStoreProductDto[] response = restTemplate.getForObject(

                "https://fakestoreapi.com/products",
                //since .getForObject expects class name as parameter, we are passing array of class name using .class keyword
                FakeStoreProductDto[].class
        );
//Although return type of method is in list, we get data in Json from the url,converting each json obj to our
// dto(Product) object and adding all those products to list and returning theme

        List<Product> answer=new ArrayList<>();
        for(FakeStoreProductDto dto: response ){
            answer.add(convertFakeStoreProductToProduct(dto));
        }
        return answer;





    }
}



