package org.africa.semicolon.dtos.Request;

import lombok.Data;

@Data
public class CreateNoteRequest {
    private  String author;
    private  String title;
    private  String body;
}
