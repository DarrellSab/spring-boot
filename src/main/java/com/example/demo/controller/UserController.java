package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import java.util.List;

//The first annotation should be CrossOrigin then RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    ///Those methods are using in application
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping(value = "/byName/{name}")
    public List<User> getUserByName(@PathVariable(value = "name") String name){
        return userService.findUserByName(name);
    }

    @GetMapping(value= "/byNameOrByBirthday/{searchText}")
    public ResponseEntity<Page<User>> getUserByNameOrByBirthday(Pageable pageable, @PathVariable(value = "searchText") String searchText){
        return new ResponseEntity<>(userService.findUserByNameOrByBirthday(pageable, searchText), HttpStatus.OK);
    }
    @GetMapping(value = "/all")
    public List<User> getUserAll(){
        return userService.findUserAll();
    }
}
