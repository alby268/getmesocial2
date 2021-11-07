package com.example.getmesocial2.repository;

import com.example.getmesocial2.model.Album;
import com.example.getmesocial2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlbumRepository extends MongoRepository <Album,String>{
    List<Album> findAllById(String id);

}
