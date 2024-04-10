package org.africa.semicolon.Data.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("User")
public class User {
    private String id;
    private String email;
    private String username;
    private String password;
    private boolean loggedIn;
    private List<Notes> notes;
}
