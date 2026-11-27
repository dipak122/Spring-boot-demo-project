package com.example.journalAPP.controller;

import com.example.journalAPP.Entity.JournalEntry;
import com.example.journalAPP.Entity.User;
import com.example.journalAPP.Service.JournalEntryService;
import com.example.journalAPP.Service.UserService;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JournalEntryService journalEntryService;

    public UserController() {
        System.out.println("I am in UserController constructor");
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        userService.saveEntry(user);
        return user;
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> UpdateUser(@RequestBody User user,@PathVariable String username){
        User userInDB = userService.findByUserName(username);
        if(userInDB!=null){
            userInDB.setUserName(!user.getUserName().equals(username) ?  user.getUserName(): username);
            userInDB.setPassword(user.getPassword());
            userService.saveEntry(userInDB);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String username){
        User user=userService.findByUserName(username);
        List<JournalEntry> all=user.getJournalEntryList();
        if(!all.isEmpty())return new ResponseEntity<>(all,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{username}")
    public ResponseEntity<?> createEntry(@RequestBody JournalEntry journalEntryObj,@PathVariable String username)
    {
        journalEntryService.saveEntry(journalEntryObj,username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}