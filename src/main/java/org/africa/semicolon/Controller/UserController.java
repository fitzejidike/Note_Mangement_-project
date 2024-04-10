package org.africa.semicolon.Controller;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Dtos.Request.CreateUserRequest;
import org.africa.semicolon.Dtos.Response.ApiResponse;
import org.africa.semicolon.Exception.UserNotFoundException;
import org.africa.semicolon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody CreateUserRequest createUserRequest){
        try {
            var result = userService.registerUser(createUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);
        }
    }

}
