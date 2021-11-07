package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.Album;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @PostMapping
    public Album saveAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }


    @GetMapping
    public List<Album> getAllAlbum() {

        return albumService.getAllAlbum();
    }


    @PutMapping
    public Album updateAlbum(@RequestBody Album album) {

        return albumService.updateAlbumById(album);
    }

    @DeleteMapping
    public void deleteAlbum(@RequestParam(name = "albumId") String albumId) {

        albumService.deleteAlbum(albumId);
    }

    @GetMapping("/find")
    public List<Album> getById(@RequestParam(name = "id") String id){

        return  albumService.getById(id);

    }

}