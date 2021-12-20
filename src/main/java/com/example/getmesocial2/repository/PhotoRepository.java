package com.example.getmesocial2.repository;

import com.example.getmesocial2.model.Photo;
import com.example.getmesocial2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository <Photo,String>{
    List<Photo> findAllById(String id);


    List<Photo> findAllByAlbumId(String id);
}