package com.example.productserviceproject.repositories.Projections;


//Created this Interface for HQL query in ProductRepository.java
public interface ProductWithidAndTitle {
// only Declare getters of the fields(Attributes) that you want to project for Query
    //for query->@Query("select p.id as id,p.title as title from Product p where p.id = 5") in ProductRepository line 31
    Long getId();
    String getTitle();
}
