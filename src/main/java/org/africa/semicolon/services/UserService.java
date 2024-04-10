package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.Notes;
import org.africa.semicolon.Dtos.Request.*;
import org.africa.semicolon.Dtos.Response.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
    LogOutResponse logout(LogOutRequest logoutRequest);
    CreateUserResponse registerUser(CreateUserRequest createUserRequest);
    String Delete(DeleteNoteRequest deleteNoteRequest);



    CreateNoteResponse createNote(CreateNoteRequest createNoteRequest);
    UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest);
    long count();






}
