package com.example.getmesocial2.service;

import com.example.getmesocial2.model.Photo;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> getAllPhoto() {

        return photoRepository.findAll();
    }

    public Photo updatePhotoById(Photo photo) {

        return photoRepository.save(photo);
    }

    public void deletePhoto(String photoId) {

        photoRepository.deleteById(photoId);
    }

    public List<Photo> getById(String photo) {

        return photoRepository.findAllById(photo);
    }
}
