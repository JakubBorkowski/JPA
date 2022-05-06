package com.github.jakubborkowski.jpa.service;

import com.github.jakubborkowski.jpa.model.User;
import com.github.jakubborkowski.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addNewUser(String description, String firstName, String lastName, String password, String userName) {
        User user = new User(description, firstName, lastName, password, userName, new ArrayList<>(), new ArrayList<>());
        userRepository.save(user);
        return user;
    }

    public User findById(Long userId){
        if(userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get();
        } else {
            return null;
        }
    }

    public boolean removeUser(Long userId){
        User user = findById(userId);
        if(user != null){
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }

    public User editUser(User newUser, Long oldUserId) {
        User oldUser = findById(oldUserId);
        if (oldUser != null && newUser != null) {
            oldUser.setDescription(newUser.getDescription());
            oldUser.setFirstName(newUser.getFirstName());
            oldUser.setLastName(newUser.getLastName());
            oldUser.setPassword(newUser.getPassword());
            oldUser.setUserName(newUser.getUserName());
            oldUser.setPayments(newUser.getPayments());
            oldUser.setDepartments(newUser.getDepartments());
            userRepository.save(oldUser);
            return oldUser;
        } else {
            return null;
        }
    }

}
