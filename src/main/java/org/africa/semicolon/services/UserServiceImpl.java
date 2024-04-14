package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.UserRepository;
import org.africa.semicolon.Exception.LoginException;
import org.africa.semicolon.dtos.Request.*;
import org.africa.semicolon.dtos.Response.*;
import org.africa.semicolon.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotesService notesService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = new User();
        user.setUsername(loginRequest.getUsername().toLowerCase());
        user.setPassword(loginRequest.getPassword().toLowerCase());
        user.setLogged(true);
        if(!user.getUsername().equals(loginRequest.getUsername())) throw  new LoginException("WRONG USERNAME ENTERED");
        if(!user.getPassword().equals(loginRequest.getPassword())) throw new LoginException("WRONG PASSWORD ENTERED");
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
        user.setLogged(false);
        userRepository.save(user);
        LogOutResponse logOutResponse = new LogOutResponse();
        logOutResponse.setUsername(logoutRequest.getUsername());
        logOutResponse.setMessage("LoggedOut Successfully");
        return logOutResponse;
    }

    @Override
    public CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setFirstname(createUserRequest.getFirstname().toLowerCase());
        user.setLastname(createUserRequest.getLastname().toLowerCase());
        user.setNumber(createUserRequest.getNumber());
        user.setUsername(createUserRequest.getUsername().toLowerCase());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        userRepository.save(user);

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setFirstname(createUserRequest.getFirstname());
        createUserResponse.setLastname(createUserRequest.getLastname());
        createUserResponse.setNumber(createUserRequest.getNumber());
        createUserResponse.setUsername(createUserRequest.getUsername());
        createUserResponse.setEmail(createUserRequest.getEmail());
        createUserResponse.setMessage("User created successfully");
        return createUserResponse;
    }


    @Override
    public AccountDeleteResponse accountDelete(AccountDeleteRequest accountDeleteRequest) {
        User user = userRepository.findByUsername(accountDeleteRequest.getUsername().toLowerCase());
        if (user == null) throw new UserNotFoundException("Username doesn't exist");
        userRepository.delete(user);

        AccountDeleteResponse accountDeleteResponse = new AccountDeleteResponse();
        accountDeleteResponse.setUsername(accountDeleteRequest.getUsername().toLowerCase());
        accountDeleteResponse.setMessage("Notes successfully deleted");
        return accountDeleteResponse;

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
    public String Delete(DeleteNoteRequest deleteNoteRequest) {
        return notesService.Delete(deleteNoteRequest);
    }

    @Override
    public long count() {
        return notesService.count();
    }

}