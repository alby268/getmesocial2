package com.example.getmesocial2.repository;

import com.example.getmesocial2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository <User,String>{
//    User findAllById(String id);
}
