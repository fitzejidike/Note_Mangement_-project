package org.africa.semicolon.Util;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.dtos.Request.AccountDeleteRequest;
import org.africa.semicolon.dtos.Request.CreateUserRequest;

public class Mapper {
    public static User mapUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setFirstname(createUserRequest.getFirstname());
        user.setLastname(createUserRequest.getLastname());
        user.setNumber(createUserRequest.getNumber());
        user.setUsername(createUserRequest.getUsername());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        return user;
    }
    public static User mapDelete(AccountDeleteRequest accountDeleteRequest){
        User user = new User();
        user.setUsername(accountDeleteRequest.getUsername());
        user.setPassword(accountDeleteRequest.getPassword());
        return user;
    }
}
