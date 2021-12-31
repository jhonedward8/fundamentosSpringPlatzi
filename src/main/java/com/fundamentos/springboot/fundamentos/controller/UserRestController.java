package com.fundamentos.springboot.fundamentos.controller;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.usecase.CreateUser;
import com.fundamentos.springboot.fundamentos.usecase.DeleteUser;
import com.fundamentos.springboot.fundamentos.usecase.GetUser;
import com.fundamentos.springboot.fundamentos.usecase.UpdateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

    private final GetUser getUser;
    private final CreateUser createUser;
    private final DeleteUser deleteUser;
    private final UpdateUser updateUser;

    @GetMapping("/")
    public List<User> getUsers(){
        return  getUser.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> removeUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public List<User> getuserPageable(@RequestParam int page, @RequestParam int size){
        return getUser.getAllPagination(page, size);
    }
}
