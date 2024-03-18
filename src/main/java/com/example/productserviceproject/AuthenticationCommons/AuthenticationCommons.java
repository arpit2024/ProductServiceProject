package com.example.productserviceproject.AuthenticationCommons;

//Utility class to validate the token-we need to call the user service
//So I have created a method called validateToken, which will take a token as input and validate it

import com.example.productserviceproject.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }


    //public boolean validateToken(String token)
    public UserDto validateToken(String token){

        //So i need to make an API call to- @PostMapping("/validate/{token}") this particular endpoint
        ResponseEntity<UserDto> userDtoResponse=
                restTemplate.postForEntity("http://localhost:8181/users/validate/"+token,
                null, UserDto.class);

        /*So when I make the above request, i wll get an object of type userDto - so copy Role & UserDto from user service
        class and paste them in product service Dto package
        convert the response to userDto & Request body is null*/

        if(userDtoResponse.getBody()==null){
            return null;
        }
        return userDtoResponse.getBody();
    }
}
/*         if(userDtoResponse.getBody()==null){
            return false;
        }
        return true;

 Here instead of returning a boolean value, we can return the user object in the
controller to get the user details
                 */



