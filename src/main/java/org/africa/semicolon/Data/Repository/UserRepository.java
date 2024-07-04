package org.africa.semicolon.Data.Repository;

import org.africa.semicolon.Data.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
   // User findByAuthor(String author);
    User findByUsername(String username);
    Optional<User> findBy(String username);

}
