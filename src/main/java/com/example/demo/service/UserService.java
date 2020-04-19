package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UsersRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;
    ///Those mehods are using in the application
    public List<User> findUserByName(String name){
        return usersRepository.findUserByNameIgnoreCase(name);
    }
    public Page<User> findUserByNameOrByBirthday(Pageable pageable, String searchText){
        return usersRepository.findUserByNameOrBirthdayIgnoreCase(pageable, searchText);
    }
    public List<User> findUserAll(){
        return  usersRepository.findAll();
    }

}
