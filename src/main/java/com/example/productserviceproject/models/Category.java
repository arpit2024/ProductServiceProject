package com.example.productserviceproject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
//A relation between product and category can either be mapped in product/category class.
@Getter
@Setter
@Entity
public class Category extends BaseModel {
/*Hey Spring this is OneToMany relation, please don't represent it again as it is already mapped in the
Product class by an attribute named category
    @OneToMany (mappedBy = "category")*/

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
//    private List<Product> products;

//so the list of products of category class and category of product class are mapped by each other
//    or showcase same relation

    private String name;

//So for all of the primitive data types we have corresponding wrapper classes
}

/*
BaseModel and category are the parent-child relationship
We use Map Superclass among 4 ways to represent this relationship in the
here we dont need a separate table for Basemodel as per the Fetching type
 */