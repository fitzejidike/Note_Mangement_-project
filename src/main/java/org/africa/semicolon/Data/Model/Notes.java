package org.africa.semicolon.Data.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Table(name = "Notes")
public class Notes {
    @Id
   @GeneratedValue(strategy = IDENTITY)
    private  Long  id;
    private  String title;
    private  String author;
    private  String  Body;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDate dateCreated;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private  LocalDate dateUpdated;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private  LocalDate dateDeleted;




}
