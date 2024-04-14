package org.africa.semicolon.dtos.Request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String number;
    private String username;
    private String password;
    private String email;
}
