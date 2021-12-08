package com.example.getmesocial2.service;

import com.example.getmesocial2.model.Album;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album saveAlbum(Album album) {


        return albumRepository.save(album);
    }

    public List<Album> getAllAlbum() {

        return albumRepository.findAll();
    }

    public Album updateAlbumById(Album album) {

        return albumRepository.save(album);
    }

    public void deleteAlbum(String albumId) {

        albumRepository.deleteById(albumId);
    }

    public List<Album> getById(String id) {

        return albumRepository.findAllById(id);
    }
}