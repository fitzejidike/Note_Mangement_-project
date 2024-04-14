package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.UserRepository;
import org.africa.semicolon.dtos.Request.CreateUserRequest;
import org.africa.semicolon.dtos.Request.DeleteNoteRequest;
import org.africa.semicolon.dtos.Request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
@Autowired
    UserRepository userRepository;
@Autowired
    UserService userService;

    @Test
    void loginTest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        userService.registerUser(createUserRequest);
        assertEquals(1,userRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("leo");
        loginRequest.setPassword("123465");
        userService.login(loginRequest);
        assertTrue(userRepository.findByUsername(loginRequest.getUsername()).isLogged());

    }

    @Test
    void logout() {
    }

    @Test
    void registerUser() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        userService.registerUser(createUserRequest);
        assertEquals(1,userRepository.count());

    }
    @Test
    void delete() {
        DeleteNoteRequest deleteNoteRequest = new DeleteNoteRequest();
        deleteNoteRequest.setTitle("F.O.E");
        deleteNoteRequest.setAuthor("fitz");
        userService.Delete(deleteNoteRequest);
        assertEquals(0, userService.count());
    }
}