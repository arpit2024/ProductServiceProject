package com.example.productserviceproject.Exceptions;



public class ProductNotExistsException extends Exception{

    //Just a Constructor of this class/Exception,
    public ProductNotExistsException(String message) {
        super(message);
    }
}

/*
// Since this class is extended there arises a question
Q) should it be more appropriate to extend RunTimeException
-> No, because we are not going to handle this exception in controller

it is always better to have compile time Exception(the more things we check in Compile time more Safer our code will be).

 */

/*
you have created productnotfoundexception class in exception package so do we need to create some manual classes everytime we create exception handler methods ?
-> No, But Ideally it is always better to have custom exception classes,Because the name of exception makes the code much more readable
*/