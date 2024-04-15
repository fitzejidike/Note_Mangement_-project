package org.africa.semicolon.services;

import org.africa.semicolon.dtos.Request.CreateNoteRequest;
import org.africa.semicolon.dtos.Request.DeleteNoteRequest;
import org.africa.semicolon.dtos.Request.UpdateNoteRequest;
import org.africa.semicolon.dtos.Response.CreateNoteResponse;
import org.africa.semicolon.dtos.Response.UpdateNoteResponse;
import org.springframework.stereotype.Service;

@Service
public interface NotesService {
    CreateNoteResponse createNote(CreateNoteRequest createNoteRequest);
    UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest);
    String delete(DeleteNoteRequest deleteNoteRequest);
    long count();

}
