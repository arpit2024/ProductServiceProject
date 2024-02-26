package com.example.productserviceproject.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


//Here we have used InheritanceType as MappedSuperclass

//Hey this class is just to have the attributes no need to create the table of this class
@Getter
@Setter
@MappedSuperclass//Explained in Error notes
public class BaseModel {

    //@GeneratedValue(strategy = GenerationType.AUTO)//Explained in Error notes
    //auto increment the value of id
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
}
/*
//BaseModel is the parent class
//Product and Category are the child classes
//Product and Category are inheriting from BaseModel

 */