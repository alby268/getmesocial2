package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.Album;
import com.example.getmesocial2.model.FirebaseUser;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.AlbumService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.getmesocial2.service.FirebaseService;

import com.google.firebase.auth.FirebaseAuthException;
import com.example.getmesocial2.exception.InvalidIdToken;



import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public Album saveAlbum(@RequestBody Album album,@RequestHeader(name="idToken") String idToken) throws  IOException,InvalidIdToken, FirebaseAuthException {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){

            album.setCreatedBy(firebaseUser.getEmail());
            return  albumService.saveAlbum(album);

        }
        else
            throw new InvalidIdToken();
    }


    @GetMapping
    public List<Album> getAllAlbum() {

        return albumService.getAllAlbum();
    }


    @PutMapping
    public Album updateAlbum(@RequestBody Album album,@RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException,InvalidIdToken{

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return albumService.updateAlbumById(album);

        }
        else
            throw new InvalidIdToken();
    }

    @DeleteMapping
    public void deleteAlbum(@RequestParam(name = "albumId") String albumId,@RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException,InvalidIdToken {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
             albumService.deleteAlbum(albumId);


        }
        else{
            throw new InvalidIdToken();
        }



    }

    @GetMapping("/find")
    public List<Album> getById(@RequestParam(name = "id") String id){

        return  albumService.getById(id);

    }

}