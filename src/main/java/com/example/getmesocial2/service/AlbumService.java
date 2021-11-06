package com.example.getmesocial2.service;

import com.example.getmesocial2.model.Album;
import com.example.getmesocial2.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album getAlbum() {

        return albumRepository.getAlbum();
    }

    public Album saveAlbum(Album album) {

        return albumRepository.saveAlbum(album);
    }

    public List<Album> getAllAlbum() {

        return albumRepository.getAllAlbum();
    }

    public Album getAlbumById(int albumId) {

        return albumRepository.getAlbumById(albumId);
    }


    public Album updateAlbumById(int albumId, Album album) {

        return albumRepository.updateAlbumById(albumId,album);
    }

    public Album deleteAlbum(int albumId) {

        return albumRepository.deleteAlbum(albumId);
    }
}
