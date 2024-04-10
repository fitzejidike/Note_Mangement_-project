package org.africa.semicolon.Dtos.Request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
    private String email;
}
