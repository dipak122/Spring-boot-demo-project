package com.example.journalAPP.Service;

import com.example.journalAPP.Entity.JournalEntry;
import com.example.journalAPP.Entity.User;
import com.example.journalAPP.Repository.JournalEntryRepository;
import com.example.journalAPP.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    public UserService(){
        System.out.println("I am in UserService constructor");
    }
    @Autowired
    private UserRepository userRepository;

    public void  saveEntry(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId id){
        return userRepository.findById(id);
    }

    public boolean isThisExist(ObjectId myid){
        return userRepository.existsById(myid);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }
    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }
}
