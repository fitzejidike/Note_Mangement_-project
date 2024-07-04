package org.africa.semicolon.Data.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;

@Setter
@Getter
@Entity
@Table(name = "_users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    private String firstname;
    private String lastname;
    private String number;
    private String email;
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Notes> notes;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeCreated;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeUpdate;

    @PrePersist
    private void setTimeCreated() {
        this.timeCreated = now();
    }

    @PreUpdate
    private void setTimeUpdated() {
        this.timeUpdate = now();
    }

}