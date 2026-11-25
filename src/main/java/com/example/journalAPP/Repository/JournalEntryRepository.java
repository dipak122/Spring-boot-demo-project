package com.example.journalAPP.Repository;

import com.example.journalAPP.Entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {

}
