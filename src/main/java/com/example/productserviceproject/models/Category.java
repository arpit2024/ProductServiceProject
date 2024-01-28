package com.example.productserviceproject.models;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String name;

//So for all of the primitive data types we have corresponding wrapper classes
}

/*
BaseModel and category are the parent-child relationship
We use Map Superclass among 4 ways to represent this relationship in the
here we dont need a separate table for Basemodel as per the Inheritance Mapping type
 */