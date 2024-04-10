package org.africa.semicolon.Data.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("Notes")
public class Notes {

    private  String title;
    private  String author;
    private  String  Body;
    private  String  id;
    private LocalDate dateCreated;



}
