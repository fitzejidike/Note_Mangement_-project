package org.africa.semicolon.Dtos.Request;

import lombok.Data;

@Data
public class UpdateNoteRequest {
    private String author;
    private String title;
    private String body;
}
