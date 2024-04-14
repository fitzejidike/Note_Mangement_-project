package org.africa.semicolon.dtos.Request;

import lombok.Data;

@Data
public class UpdateNoteRequest {
    private String author;
    private String title;
    private String body;
}
