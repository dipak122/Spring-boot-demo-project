package com.example.journalAPP.Repository;

import com.example.journalAPP.Entity.JournalEntry;
import com.example.journalAPP.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);
}
