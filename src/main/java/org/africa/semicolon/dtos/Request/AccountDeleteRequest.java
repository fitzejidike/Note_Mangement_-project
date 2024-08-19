package org.africa.semicolon.dtos.Request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDeleteRequest {
    private String username;
    private String Password;
}
