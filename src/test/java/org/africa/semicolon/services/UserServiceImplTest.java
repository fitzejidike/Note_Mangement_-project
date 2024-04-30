package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.UserRepository;
import org.africa.semicolon.Exception.UserAlreadyExistRequest;
import org.africa.semicolon.dtos.Request.*;
import org.africa.semicolon.dtos.Response.LogOutResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
@Autowired
    UserRepository userRepository;
@Autowired
    UserService userService;
    @BeforeEach
    void clearAll(){
        userRepository.deleteAll();


    }

    @Test
    void loginTest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setUsername("foe");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        userService.registerUser(createUserRequest);
        assertEquals(1,userRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("foe");
        loginRequest.setPassword("123465");
        userService.login(loginRequest);
        assertTrue(userRepository.findByUsername(loginRequest.getUsername()).isLogged());

    }

    @Test
    void logoutTest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setUsername("foe");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        userService.registerUser(createUserRequest);
        assertEquals(1,userRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("foe");
        loginRequest.setPassword("123465");
        userService.login(loginRequest);
        assertTrue(userRepository.findByUsername(loginRequest.getUsername()).isLogged());
        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUsername("foe");
        userService.logout(logOutRequest);
        assertFalse(userRepository.findByUsername(logOutRequest.getUsername()).isLogged());

    }

    @Test
    void registerUser() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setUsername("natus");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        userService.registerUser(createUserRequest);
        assertEquals(1,userRepository.count());

    }
    @Test
    void CannotRegisterTwice(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setUsername("natus");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        userService.registerUser(createUserRequest);

        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setUsername("natus");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        //userService.registerUser(createUserRequest);

        assertThrows(UserAlreadyExistRequest.class,()-> userService.registerUser(createUserRequest));

    }
    @Test
    void test_to_delete_account() {

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstname("leo");
        createUserRequest.setLastname("dike");
        createUserRequest.setUsername("natsu");
        createUserRequest.setNumber("09150429499");
        createUserRequest.setPassword("123465");
        createUserRequest.setEmail("leo@gmail.com");
        userService.registerUser(createUserRequest);
        assertEquals(1,userRepository.count());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("natsu");
        loginRequest.setPassword("123465");
        userService.login(loginRequest);

        AccountDeleteRequest accountDeleteRequest = new AccountDeleteRequest();
        accountDeleteRequest.setUsername("natsu");
        accountDeleteRequest.setPassword("123465");
        userService.accountDelete(accountDeleteRequest);
        assertEquals(0,userRepository.count());



    }
}