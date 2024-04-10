package org.africa.semicolon.Dtos.Response;

import lombok.Data;

@Data
public class UpdateNoteResponse {
    private String author;
    private String title;
    private String body;
    private String message;
}
