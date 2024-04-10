package org.africa.semicolon.Dtos.Request;

import lombok.Data;

@Data
public class DeleteNoteRequest {
    private String author;
    private String title;
}
