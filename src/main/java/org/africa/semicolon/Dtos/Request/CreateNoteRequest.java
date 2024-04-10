package org.africa.semicolon.Dtos.Request;

import lombok.Data;

@Data
public class CreateNoteRequest {
    private  String author;
    private  String title;
    private  String body;
}
