package com.example.productserviceproject.dtos;

// this class is created to cretae a custom exception
//we are using an object from this class in ExceptionHandlers class


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {

    private String message;

    private String details;
}
