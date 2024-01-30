package com.example.productserviceproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
//@entity annotation is used to mark the class as an entity class
//so that hibernate can recognize it as an entity class
//and create a table for it in the database

public class Product extends BaseModel {


    private String title;
    private Double price;
    //Double should be Capital 'D'ouble not double
@ManyToOne
    private Category category;
    private String description;
    private String imageUrl;
//  Non-Primitive attributes are the type whose data type is another class.
//  Here comes the concept of Cardinality.

}
/*Steps to create a table in database
1)for every class create a corresponding table
2)for all the primitive attributes create a column in the table

General Ques
Q)What is the cardinality between the product and category?
A)Many to one
    1   ->   1
Product : Category
    m   ->   1
--------------------
    m   :   1

 */

