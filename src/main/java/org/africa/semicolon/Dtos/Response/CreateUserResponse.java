package org.africa.semicolon.Dtos.Response;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String username;
    private String password;
    private String email;
    private String messsage;
}
