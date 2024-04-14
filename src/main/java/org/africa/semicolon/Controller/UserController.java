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

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CreateUserRequest createUserRequest){
        try {
            var result = userService.registerUser(createUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, result),CREATED);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            var result = userService.login(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
        }catch (LoginException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);
        }
    }
    @PostMapping("/Logout")
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
            var result = userService.accountDelete(accountDeleteRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
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
    }@PostMapping("/updateNote")
    public ResponseEntity<?>updateNote(@RequestBody UpdateNoteRequest updateNoteRequest){
        try{
            var result = userService.updateNote(updateNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
        }catch (SuperNoteException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),BAD_REQUEST);
        }
    }
    @DeleteMapping("/accountDelete")
    public ResponseEntity<?> Delete(@RequestBody DeleteNoteRequest DeleteNoteRequest) {
        try {
            var result = userService.Delete(DeleteNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (SuperNoteException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
}
