package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.Photo;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo){
        return photoService.savePhoto(photo);
    }


    @GetMapping
    public List<Photo> getAllPhoto() {

        return photoService.getAllPhoto();
    }


    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){

        return photoService.updatePhotoById(photo);
    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "photoId") String photoId){

        photoService.deletePhoto(photoId);
    }

    @GetMapping("/find")
    public List<Photo> getById(@RequestParam(name = "id") String id){

        return  photoService.getById(id);

    }




}
