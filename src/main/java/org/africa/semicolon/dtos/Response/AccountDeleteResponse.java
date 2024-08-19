package org.africa.semicolon.dtos.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDeleteResponse {
    private String username;
    private String message;
}
