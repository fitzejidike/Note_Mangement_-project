package org.africa.semicolon.Data.Repository;

import org.africa.semicolon.Data.Model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes,String> {
        Notes findNotesByTitle(String title);

}
