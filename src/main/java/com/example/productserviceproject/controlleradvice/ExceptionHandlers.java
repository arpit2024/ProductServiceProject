package com.example.productserviceproject.controlleradvice;
//These are GLOBAL Exception Handlers
/* Centralized Location for Handling exception in API's

calling try-catch in every method is not a good practice to handle exceptions.
whenever an exception is thrown ,we should try to send a helpful response back to the user instead of a stack trace.

we got to know that whatever the class or method(controller/service/business logic) that is throwing the exception, it should pass through controller back to the user.
Controller is the final thing through which exception pass to user.

so we are using another class called controller advice- an additional check on whatever retrieved by controller.

@controller advice - whenever an exception is thrown from any controller/class/methods, we can have methods within this class that may modify the response that is sent back to client.
Example - Sensor Board for Movie
controllers dont catch the exceptions, they just return whatever sent by service class or ....
but after controller these class-controlleradvice catch the exception and return the print statement that we have written in the method of this class.
 */

import com.example.productserviceproject.Exceptions.ProductNotExistsException;
import com.example.productserviceproject.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {


    //This method should be called when arithmetic exception is thrown
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Void> handleArithmeticException(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> handleArrayIndexOutOfBoundsException(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto> handleProductNotExistsException(
            // we can take an object from ProductNotExistsException class as an parameter for this method;
            ProductNotExistsException exception
    ){
        //Typically in case of exception we can also have an dto class
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage(exception.getMessage());

        return new ResponseEntity<>(dto,HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
/*Use of Dto class object
we can use dto class object to send the message to the user instead of just throwing exception
so that when something goes wrong, we can give the client some detail, using which the client can hopefully recover
ex-  dto.setDetails("Check the product Number , probably it doesn't exist")
 */

/*
Note:-
since we are using controller advice, we don't need to use try-catch in controller methods.
but if we do use try-catch in controller methods, then the exception will be caught by controller method and not by controller advice.


Suppose we have multiple controller class then on each class we annotate with @ControllerAdvice
 */

}
