package com.example.journalAPP.controller;
import com.example.journalAPP.Entity.JournalEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private static final Logger log = LoggerFactory.getLogger(JournalEntryController.class);

    public  JournalEntryController(){
       System.out.println("I am in JournalEntryController constructor");
//       addSomeValues();
       System.out.println(journalEntries.values());
    }
    private Map<Long, JournalEntry> journalEntries=new HashMap<>();
    public void addSomeValues(){
//        JournalEntry je=new JournalEntry(123,"System Enginner","This is a new content");
//        journalEntries.put(je.getId(),je);
//        journalEntries.put(234L,new JournalEntry(123,"System Enginner","This is a new content"));
    }
    public void printJournalEntry(){
//        journalEntries.forEach((Map.Entry.)->System.out.println());
    }

    @GetMapping
    public List<JournalEntry> getALL(){
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/id/{myid}")
    public JournalEntry getJournalEntryByID(@PathVariable Long myid){
        return journalEntries.get(myid);
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry j){
//        journalEntries.put(j.getId(),j);
        return true;
    }
    @DeleteMapping("/id/{myid}")
    public boolean deleteJournalEntry(@PathVariable Long myid){
        if(journalEntries.containsKey(myid))
        {journalEntries.remove(myid);return true;}
        return false;
    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntry(@PathVariable Long id,@RequestBody JournalEntry j){
        journalEntries.put(id,j);
        return journalEntries.get(id);
    }
}
