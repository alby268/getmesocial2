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

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {

        return userRepository.findAll();
    }

        public User updateUserById(User user) {

        return userRepository.save(user);
    }

        public void deleteUser(String userId) {

         userRepository.deleteById(userId);
    }

    public User getById(String id) {

      return userRepository.findById(id).get();
    }


}
