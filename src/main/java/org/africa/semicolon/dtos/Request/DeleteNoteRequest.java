package org.africa.semicolon.dtos.Request;

import lombok.Data;

@Data
public class DeleteNoteRequest {
    private String author;
    private String title;
}
