package org.africa.semicolon.dtos.Response;

import lombok.Data;

@Data
public class UpdateNoteResponse {
    private String author;
    private String title;
    private String message;
}
