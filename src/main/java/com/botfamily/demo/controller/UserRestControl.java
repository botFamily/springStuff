package com.botfamily.demo.controller;

import com.botfamily.demo.model.User;
import com.botfamily.demo.service.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserRestControl {

    private UserRepo userRepo;

    @Autowired
    public UserRestControl(UserRepo userRepo){
        this.userRepo =userRepo;
    }

    @GetMapping
    public Iterable<User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent())
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public User addUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") Long id){
        try {
            userRepo.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        user.setId(id);
        return userRepo.save(user);
    }

}
