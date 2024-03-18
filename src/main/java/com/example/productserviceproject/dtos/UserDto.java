package com.example.productserviceproject.dtos;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

//Copied this class from UserService
@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> role;
    private boolean isEmailVerified;


}


/*Reason For this Class

i removed some of the fields from the UserDto class, as we its just a dto not an entity or
something, and I dont need them
These are not something that need to be stored in DB, so I removed them

-->
so while implementing the validation of token, we need to return the user details if the token is valid.
but in our code we were directly returning the User class object from the service method.
Controller method before changes:

but we should not return the User class object directly from the service method,
instead we should create a DTO class and return the object of that DTO class from the service method.
 */