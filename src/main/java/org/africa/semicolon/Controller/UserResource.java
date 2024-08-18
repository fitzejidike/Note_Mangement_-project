package org.africa.semicolon.Controller;

import org.africa.semicolon.dtos.Request.*;
import org.africa.semicolon.dtos.Response.ApiResponse;
import org.africa.semicolon.Exception.LoginException;
import org.africa.semicolon.Exception.SuperNoteException;
import org.africa.semicolon.Exception.UserNotFoundException;
import org.africa.semicolon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/user")
public class UserResource {


    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CreateUserRequest createUserRequest){

            var result = userService.registerUser(createUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, result),CREATED);


    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            var result = userService.login(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
        }catch (LoginException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogOutRequest logOutRequest){
        try {
            var result = userService.logout(logOutRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        }catch (SuperNoteException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);


        }
    }
    @DeleteMapping("/accountDelete")
    public ResponseEntity<?> accountDelete(@RequestBody AccountDeleteRequest accountDeleteRequest){
        try{
            userService.accountDelete(accountDeleteRequest);
            return new ResponseEntity<>(new ApiResponse(true,"Deleted"),CREATED);
        }catch (SuperNoteException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);
        }

    }
    @PostMapping("/createNote")
    public ResponseEntity<?>createNote(@RequestBody CreateNoteRequest createNoteRequest){
        try{
            var result = userService.createNote(createNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
        }catch (SuperNoteException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);
        }
    }
    @PostMapping("/updateNote")
    public ResponseEntity<?>updateNote(@RequestBody UpdateNoteRequest updateNoteRequest){
        try{
            var result = userService.updateNote(updateNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
        }catch (SuperNoteException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteNoteRequest DeleteNoteRequest) {
        try {
            var result = userService.delete(DeleteNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (SuperNoteException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
}
