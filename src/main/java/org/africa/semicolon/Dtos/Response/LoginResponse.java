package org.africa.semicolon.Dtos.Response;

import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private  String message = "login successful";

}
