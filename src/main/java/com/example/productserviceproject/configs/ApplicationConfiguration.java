package com.example.productserviceproject.configs;
// Application Context class
/*
How Do we create a Bean?
we create a class called Configuration (Name can be anything).
 */
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
// After Annotation, Spring will get to know that i have to have a bean of restTemplate
public class ApplicationConfiguration {

// i want to create a Bean so use Bean Annotation
    @Bean
    public RestTemplate  createRestTemplate()
    {
        return new RestTemplateBuilder().build();
    }
// i am creating a Bean of type Rest template

// if we create two beans of rest template it would through an error as spring
// will get confuse to which object need to be injected
}

/*
Container-Helper Class

How do we use a RestTemplate Library?
if i have a object and I call a method on that object which is behind the scene going to make a call to APi-
i will not be required multiple instances of the object, single object is enough, and there is possibility of many
classes within my CodeBase require to call 3rd party API's.

if the Above is True, then Do we agree to have an object to call 3rd party api is good.
now the Question is-> is there a Feature of Spring that can allow me to keep an object at a common Place, and in whatever class we need, we can inject that.
-> This common Place is called Spring's Application Context, And the objects that we put in the Spring Application Context are called as BEANS.


Bean will be Available across all the classes (Bean - it is nothing but an object that is present in Spring's Application Context which I can use in any class)

a) Put a Bean of RestTemplate in Application Context
b)use that bean Across Other Classes

 */