package org.africa.semicolon.dtos.Response;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String firstname;
    private String lastname;
    private String number;
    private String username;
    private String email;
    private String Message;
}
