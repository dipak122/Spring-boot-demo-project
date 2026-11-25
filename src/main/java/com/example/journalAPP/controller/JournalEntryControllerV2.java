package com.example.journalAPP.controller;

import com.example.journalAPP.Entity.JournalEntry;
import com.example.journalAPP.Service.JournalEntryService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    public JournalEntryControllerV2(){
       System.out.println("I am in JournalEntryControllerV2 constructor");
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry j){
        try {
            j.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(j);
            return new ResponseEntity<>(j, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public ResponseEntity<List<JournalEntry>> getALL(){
        if(journalEntryService.getAll().isEmpty()){
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(journalEntryService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/id/{myid}")
    public ResponseEntity<Optional<JournalEntry>> getJournalEntryByID(@PathVariable ObjectId myid){
        Optional<JournalEntry> journalEntry = journalEntryService.getById(myid);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/id_/{myid}")
    public ResponseEntity<Boolean>  isThisJournalEntryExistById(@PathVariable ObjectId myid){
        Boolean journalEntry = journalEntryService.isThisExist(myid);
        if(journalEntry){
            return new ResponseEntity<>(journalEntry,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<Optional<JournalEntry>>  deleteJournalEntry(@PathVariable ObjectId myid) {
        Optional<JournalEntry> journalEntry = journalEntryService.getById(myid);
        if (journalEntry.isPresent()) {
            journalEntryService.deleteById(myid);
            return new ResponseEntity<>(journalEntry, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
JournalEntry old=journalEntryService.getById(id).orElse(null);
if(old!=null){
    old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
    old.setContent(newEntry.getContent()!=null && newEntry.getContent().isEmpty() ? old.getContent() : newEntry.getContent());
}
else{
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
journalEntryService.saveEntry(old);
        return new ResponseEntity<>(old,HttpStatus.OK);
    }
}
