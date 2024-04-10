package org.africa.semicolon.services;

import org.africa.semicolon.Dtos.Request.CreateNoteRequest;
import org.africa.semicolon.Dtos.Request.DeleteNoteRequest;
import org.africa.semicolon.Dtos.Request.UpdateNoteRequest;
import org.africa.semicolon.Dtos.Response.CreateNoteResponse;
import org.africa.semicolon.Dtos.Response.DeleteNoteResponse;
import org.africa.semicolon.Dtos.Response.UpdateNoteResponse;
import org.springframework.stereotype.Service;

@Service
public interface NotesService {
    CreateNoteResponse createNote(CreateNoteRequest createNoteRequest);
    UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest);
    long count();

}
