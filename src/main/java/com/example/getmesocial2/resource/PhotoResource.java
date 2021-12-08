package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.Photo;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.getmesocial2.service.FirebaseService;

import com.example.getmesocial2.model.FirebaseUser;

import com.google.firebase.auth.FirebaseAuthException;
import com.example.getmesocial2.exception.InvalidIdToken;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo,@RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException,InvalidIdToken {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return photoService.savePhoto(photo);

        }
        else
            throw new InvalidIdToken();
    }




    @GetMapping
    public List<Photo> getAllPhoto() {

        return photoService.getAllPhoto();
    }


    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo,@RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException,InvalidIdToken {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return photoService.updatePhotoById(photo);
        }
        else

            throw new InvalidIdToken();


    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "photoId") String photoId,@RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException,InvalidIdToken {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            photoService.deletePhoto(photoId);

        }
        else
            throw new InvalidIdToken();



    }

    @GetMapping("/find")
    public List<Photo> getById(@RequestParam(name = "id") String id){

        return  photoService.getById(id);

    }




}
