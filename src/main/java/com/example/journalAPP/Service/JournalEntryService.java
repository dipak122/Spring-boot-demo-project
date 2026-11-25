package com.example.journalAPP.Service;

import com.example.journalAPP.Entity.JournalEntry;
import com.example.journalAPP.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    public JournalEntryService(){
        System.out.println("I am in JournalEntryService constructor");
    }
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void  saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id){
        return journalEntryRepository.findById(String.valueOf(id));
    }

    public boolean isThisExist(ObjectId myid){
        return journalEntryRepository.existsById(String.valueOf(myid));
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(String.valueOf(id));
    }
}
