package org.africa.semicolon.services;

import org.africa.semicolon.dtos.Request.*;
import org.africa.semicolon.dtos.Response.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
    LogOutResponse logout(LogOutRequest logoutRequest);
    CreateUserResponse registerUser(CreateUserRequest createUserRequest);
    AccountDeleteResponse accountDelete(AccountDeleteRequest accountDeleteRequest);



    CreateNoteResponse createNote(CreateNoteRequest createNoteRequest);
    UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest);
    String Delete(DeleteNoteRequest deleteNoteRequest);
    long count();






}
