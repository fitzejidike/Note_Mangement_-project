package org.africa.semicolon.dtos.Response;

import lombok.Data;

@Data
public class CreateNoteResponse {
    private  String author;
    private  String message;
}
