package org.africa.semicolon.dtos.Response;

import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private  String message = "login successful";

}
