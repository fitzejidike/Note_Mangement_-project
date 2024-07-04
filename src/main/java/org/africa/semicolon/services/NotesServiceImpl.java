package org.africa.semicolon.services;

import org.africa.semicolon.Data.Model.Notes;
import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.NotesRepository;
import org.africa.semicolon.Exception.UserNotFoundException;
import org.africa.semicolon.dtos.Request.CreateNoteRequest;
import org.africa.semicolon.dtos.Request.DeleteNoteRequest;
import org.africa.semicolon.dtos.Request.UpdateNoteRequest;
import org.africa.semicolon.dtos.Response.CreateNoteResponse;
import org.africa.semicolon.dtos.Response.DeleteNoteResponse;
import org.africa.semicolon.dtos.Response.UpdateNoteResponse;
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
        createNoteResponse.setAuthor(createNoteRequest.getAuthor());
        createNoteResponse.setMessage("Note created successfully");
        return createNoteResponse;

    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest) {
        Notes note = notesRepository.findNotesByTitle(updateNoteRequest.getTitle());
        note.setAuthor(updateNoteRequest.getAuthor());
        note.setTitle(updateNoteRequest.getTitle());
        note.setBody(updateNoteRequest.getBody());
        notesRepository.save(note);

        UpdateNoteResponse updateNoteResponse = new UpdateNoteResponse();
        updateNoteResponse.setAuthor(updateNoteRequest.getAuthor());
        updateNoteResponse.setTitle(updateNoteRequest.getTitle());
        updateNoteResponse.setMessage("Update Successful");
        return updateNoteResponse;
    }

    @Override
    public String delete(DeleteNoteRequest deleteNoteRequest) {
        Notes notes = notesRepository.findNotesByTitle(deleteNoteRequest.getTitle());
        if (notes == null) throw new NotesNotFoundException("title doesn't exist");
        notesRepository.delete(notes);

        DeleteNoteResponse deleteNoteResponse = new DeleteNoteResponse();
        String message;
        message = "Notes successfully deleted";
        return message;
    }


    private  Notes findByTitle(String title){
        Notes notes = notesRepository.findNotesByTitle(title);
        if(notes == null) throw  new NotesNotFoundException("note not found");
        return notes;

        }
    @Override
    public long count() {
        return  notesRepository.count();
    }
}
