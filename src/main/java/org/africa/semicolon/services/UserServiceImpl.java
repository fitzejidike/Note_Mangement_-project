package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.UserRepository;
import org.africa.semicolon.Dtos.Request.*;
import org.africa.semicolon.Dtos.Response.*;
import org.africa.semicolon.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private NotesService notesService;
    private UserService userService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        user.setLoggedIn(true);
        userRepository.save(user);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(loginRequest.getUsername());
        loginResponse.setMessage("Login successfully");
        return loginResponse;
    }

    @Override
    public LogOutResponse logout(LogOutRequest logoutRequest) {
        User user = new User();
        user.setUsername(logoutRequest.getUsername());
        user.setLoggedIn(false);
        userRepository.save(user);
        LogOutResponse logOutResponse = new LogOutResponse();
        logOutResponse.setUsername(logoutRequest.getUsername());
        logOutResponse.setMessage("LoggedOut Successfully");
        return logOutResponse;
    }

    @Override
    public CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        userService.registerUser(createUserRequest);
        userRepository.save(user);

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUsername(createUserRequest.getUsername());
        createUserResponse.setMesssage("User created successfully");
        return createUserResponse;
    }


    @Override
    public String Delete(DeleteNoteRequest deleteNoteRequest) {
        User user = userRepository.findByUsername(deleteNoteRequest.getAuthor());
        if (user == null) throw new UserNotFoundException("User doesn't exist");
        user.

    }

    @Override
    public CreateNoteResponse createNote(CreateNoteRequest createNoteRequest) {
        return notesService.createNote(createNoteRequest);
    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest) {
        return notesService.updateNote(updateNoteRequest);
    }

    @Override
    public long count() {
        return notesService.count();
    }

}