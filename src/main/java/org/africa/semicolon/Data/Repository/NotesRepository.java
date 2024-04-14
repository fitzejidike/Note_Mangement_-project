package org.africa.semicolon.Data.Repository;

import org.africa.semicolon.Data.Model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<Notes,String> {
        Notes findNotesByTitle(String title);

}
