package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.Notes;
import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.NotesRepository;
import org.africa.semicolon.Data.Repository.UserRepository;
import org.africa.semicolon.Dtos.Request.CreateNoteRequest;
import org.africa.semicolon.Dtos.Request.DeleteNoteRequest;
import org.africa.semicolon.Dtos.Request.UpdateNoteRequest;
import org.africa.semicolon.Dtos.Response.CreateNoteResponse;
import org.africa.semicolon.Dtos.Response.DeleteNoteResponse;
import org.africa.semicolon.Dtos.Response.UpdateNoteResponse;
import org.africa.semicolon.Exception.NotesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesServiceImpl implements NotesService{
    @Autowired
    NotesRepository notesRepository;
    @Override
    public CreateNoteResponse createNote(CreateNoteRequest createNoteRequest) {
       Notes notes = new Notes();
        notes.setTitle(createNoteRequest.getTitle());
        notes.setAuthor(createNoteRequest.getAuthor());
        notes.setBody(createNoteRequest.getBody());
        notesRepository.save(notes);
        CreateNoteResponse createNoteResponse = new CreateNoteResponse();
        createNoteResponse.setTitle(createNoteRequest.getTitle());
        createNoteResponse.setAuthor(createNoteRequest.getAuthor());
        createNoteResponse.setBody(createNoteRequest.getBody());
        createNoteResponse.setMessage("Note created successfully");
        return createNoteResponse;

    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest) {
        Notes note = new Notes();
        note.setAuthor(updateNoteRequest.getAuthor());
        note.setTitle(updateNoteRequest.getTitle());
        notesRepository.save(note);

        UpdateNoteResponse updateNoteResponse = new UpdateNoteResponse();
        updateNoteResponse.setAuthor(updateNoteRequest.getAuthor());
        updateNoteResponse.setTitle(updateNoteRequest.getTitle());
        updateNoteResponse.setMessage("Update Successful");
        return updateNoteResponse;
    }
        private  Notes FindByTitle(String title){
        Notes notes = notesRepository.findNotesByTitle(title);
        if(notes == null) throw  new NotesNotFoundException("note not found");
        return notes;

        }
    @Override
    public long count() {
        return  notesRepository.count();
    }
}
