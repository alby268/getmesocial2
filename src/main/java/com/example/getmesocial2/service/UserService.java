package com.example.getmesocial2.service;

import com.example.getmesocial2.model.User;
import com.example.getmesocial2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User getUser() {

        return userRepository.getUser();
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public List<User> getAllUser() {

        return userRepository.getAllUser();
    }

    public User getUserById(int userId) {

        return userRepository.getUserById(userId);
    }


    public User updateUserById(int userId, User user) {

        return userRepository.updateUserById(userId,user);
    }

    public User deleteUser(int userId) {

        return userRepository.deleteUser(userId);
    }
}
