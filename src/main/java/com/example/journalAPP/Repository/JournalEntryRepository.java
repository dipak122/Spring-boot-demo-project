package com.example.journalAPP.Repository;

import com.example.journalAPP.Entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {

//    SimpleMongoRepository
}
