package com.example.productserviceproject.dtos;
/*
How do we make an API call to 3rd Party
we need an Library to do the same- Maven(right side Icon)->Dependencies->Spring Web->imported a class called RestTemplate
RestTemplate(Rest Client)- Basically a class which helps in Calling 3rd Party
RestTemplate Class-This class is used to make an API call to any URl ex- resttempate.get("Https://google.com");
Another ex-Webclient Library, Axios
/*
 */
import lombok.Getter;
import lombok.Setter;
//Created to replicate data similar to to api is sending it.Datatype)
//we need to create this class thinking how the Api's are responding
@Getter
@Setter
//in FakeStoreProductService we call the URL for single product we get some data(in the form of JSON)that is from FakeStore Database
//Ex:- data(JSON) like title,price,CATEGORY,Description,img
// so in our product we don't have one like it. ex- in my product class, category is of type category. but in fakestore JSON data it is sending category of String

// So we need a Datatype that is there to talk Externally called DTO

//so when i make a request at URL in fakeStore class, i will get a Data pack,
// this data(All attributes of JSON) has one-on-one mapping with the object of the FakeStoreDto class
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
