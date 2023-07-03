package com.example.demorest.service;

import com.example.demorest.entity.User;
import com.example.demorest.repository.UserRepository;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public Boolean getUserEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return user != null ? true : false;
    }


    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }


    public User createUser(User user){
        return userRepository.save(user);
    }


    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();

    }


    public User updateUser(Integer id, User user){

        Optional<User> user1 = userRepository.findById(id);

        if(user1.isPresent()){
            User user3 = user1.get();
            user3.setPassword(user.getPassword());
            user3.setEmail(user.getEmail());
            user3.setUsername(user.getUsername());
            return userRepository.save(user3);
        }

        return null;

    }


    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }



}
