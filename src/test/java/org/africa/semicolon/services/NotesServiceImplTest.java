package org.africa.semicolon.services;

import org.africa.semicolon.Data.Repository.NotesRepository;
import org.africa.semicolon.dtos.Request.CreateNoteRequest;
import org.africa.semicolon.dtos.Request.DeleteNoteRequest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@SpringBootTest
class NotesServiceImplTest {
@Autowired
NotesRepository notesRepository;

@Autowired
NotesService notesService;

    @Test
    void test_to_delete_note() {
        CreateNoteRequest createNoteRequest = new CreateNoteRequest();
        createNoteRequest.setAuthor("zoey");
        createNoteRequest.setTitle("adventures");
        createNoteRequest.setBody("am going to enter highschool");
        notesService.createNote(createNoteRequest);
        assertEquals(1,notesRepository.count());
        DeleteNoteRequest deleteNoteRequest = new DeleteNoteRequest();
        deleteNoteRequest.setTitle("adventures ");
        deleteNoteRequest.setAuthor("zoey");
        notesService.Delete(deleteNoteRequest);
        assertEquals(0, notesRepository.count());
    }


    @Test
    void createNote() {
        CreateNoteRequest createNoteRequest = new CreateNoteRequest();
        createNoteRequest.setAuthor("zoey");
        createNoteRequest.setTitle("adventures");
        createNoteRequest.setBody("am going to enter highschool");
        notesService.createNote(createNoteRequest);
        assertEquals(1,notesRepository.count());

    }

    @Test
    void updateNote() {
    }

    @Test
    void count() {
    }
}