package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.Album;
import com.example.getmesocial2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private AlbumService AlbumService;

    @GetMapping("/Album1")
    public Album getAlbum() {

        return AlbumService.getAlbum();
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album Album){
        return AlbumService.saveAlbum(Album);
    }


    @GetMapping("/album")
    public List<Album> getAllAlbum() {

        return AlbumService.getAllAlbum();
    }

    @GetMapping("/album/{albumId}")
    public Album getAlbumById(@PathVariable("albumId") int albumId){

        return AlbumService.getAlbumById(albumId);
    }


    @PutMapping("/album/{albumId}")
    public Album updateAlbum(@PathVariable("albumId") int albumId,@RequestBody Album Album){

        return AlbumService.updateAlbumById(albumId,Album);
    }


    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name = "albumId") int albumId){

        return AlbumService.deleteAlbum(albumId);
    }





}
