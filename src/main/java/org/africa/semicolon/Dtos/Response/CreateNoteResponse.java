package org.africa.semicolon.Dtos.Response;

import lombok.Data;

@Data
public class CreateNoteResponse {
    private  String author;
    private  String title;
    private  String body;
    private  String message;
}
