package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.UserRepository;
import org.africa.semicolon.Exception.InvalidPasswordException;
import org.africa.semicolon.Exception.LoginException;
import org.africa.semicolon.Exception.UserAlreadyExistRequest;
import org.africa.semicolon.dtos.Request.*;
import org.africa.semicolon.dtos.Response.*;
import org.africa.semicolon.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.africa.semicolon.Util.Mapper.mapDelete;
import static org.africa.semicolon.Util.Mapper.mapUser;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotesService notesService;


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        validatePassword(loginRequest.getPassword(),user);
        validateUserName(loginRequest.getUsername(),user);
        user.setLogged(true);
        userRepository.save(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(loginRequest.getUsername());
        loginResponse.setMessage("Login successfully");
        return loginResponse;
    }
    private static void validateUserName(String userName,User user){
        if(!user.getUsername().equals(user.getUsername())) throw  new LoginException("WRONG USERNAME ENTERED");
    }

    @Override
    public LogOutResponse logout(LogOutRequest logoutRequest) {
        User user = userRepository.findByUsername(logoutRequest.getUsername());
        validateUserName(logoutRequest.getUsername(),user);
        user.setLogged(false);
        userRepository.save(user);
        LogOutResponse logOutResponse = new LogOutResponse();
        logOutResponse.setUsername(logoutRequest.getUsername());
        logOutResponse.setMessage("LoggedOut Successfully");
        return logOutResponse;
    }

    @Override
    public CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        check(createUserRequest.getUsername().toLowerCase());
        userRepository.save(mapUser(createUserRequest));

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setFirstname(createUserRequest.getFirstname());
        createUserResponse.setMessage("User Created Successfully");
        return createUserResponse;
    }


    @Override
    public void accountDelete(AccountDeleteRequest accountDeleteRequest) {
        User user = userRepository.findByUsername(accountDeleteRequest.getUsername());
        validateLogin(user);
        userRepository.delete(user);


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
    public String delete(DeleteNoteRequest deleteNoteRequest) {
        return notesService.delete(deleteNoteRequest);
    }

    @Override
    public long count() {
        return notesService.count();
    }
    private  void check(String username){

        User user = userRepository.findByUsername(username);
         if (!(user == null))
             throw new UserAlreadyExistRequest("User Already exist");
    }
    private void  validateLogin(User user){
        if(!user.isLogged())throw new LoginException("User not logged in");
    }
    private static  void validatePassword(String password,User user){
        if(!password.equals(user.getPassword())) throw new InvalidPasswordException("Invalid Password Entered");
    }
}
