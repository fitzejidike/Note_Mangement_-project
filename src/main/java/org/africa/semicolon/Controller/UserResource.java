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

import static org.hibernate.query.results.Builders.entity;
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
    public ResponseEntity<?> registerUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse(userService.registerUser(createUserRequest), true));


    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse(userService.login(loginRequest), true));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogOutRequest logOutRequest) {
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse(userService.logout(logOutRequest), true));


    }

    @DeleteMapping("/accountDelete")
    public ResponseEntity<?> accountDelete(@RequestBody AccountDeleteRequest request) {
        return ResponseEntity.status(OK)
                .body(new ApiResponse(userService.accountDelete(request), true));

    }

    @PostMapping("/createNote")
    public ResponseEntity<?> createNote(@RequestBody CreateNoteRequest createNoteRequest) {
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse(userService.createNote(createNoteRequest), true));
    }

    @PostMapping("/updateNote")
    public ResponseEntity<?> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest) {
       return ResponseEntity.status(ACCEPTED).body(new ApiResponse(userService.updateNote(updateNoteRequest),true));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteNoteRequest deleteNoteRequest) {
        return ResponseEntity.status(OK)
                .body(new ApiResponse(userService.delete(deleteNoteRequest), true));
    }

}