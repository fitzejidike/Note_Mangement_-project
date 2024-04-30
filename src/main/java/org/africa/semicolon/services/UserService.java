package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.dtos.Request.*;
import org.africa.semicolon.dtos.Response.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
    LogOutResponse logout(LogOutRequest logoutRequest);
    CreateUserResponse registerUser(CreateUserRequest createUserRequest);
    void accountDelete(AccountDeleteRequest accountDeleteRequest);



    CreateNoteResponse createNote(CreateNoteRequest createNoteRequest);
    UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest);
    String delete(DeleteNoteRequest deleteNoteRequest);
    long count();






}
