package com.example.getmesocial2.repository;

import com.example.getmesocial2.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList = new ArrayList();

    public Album getAlbum() {

        Album album = new Album("albin","blueberry","");
        return album;
    }

    public Album saveAlbum(Album album) {

        album.setAlbumId(albumList.size()+1);

        albumList.add(album);
        return album;

    }

    public List<Album> getAllAlbum() {
        return albumList;
    }

    public Album getAlbumById(int albumId) {
        for(Album album:albumList) {

            if(album.getAlbumId() == albumId) {
                return album;
            }
        }

        return null;


    }

    public Album updateAlbumById(int albumId, Album album) {

        for(Album album1:albumList) {

            if(album1.getAlbumId() == albumId) {

                album1.setDescription(album.getDescription());
                album1.setName(album.getName());
                album1.setCoverPicUrl(album.getCoverPicUrl());
                return album1;
            }
        }

        return null;


    }

    public Album deleteAlbum(int albumId) {

        Album deletedAlbum = null;
        for(Album album1:albumList) {

            if(album1.getAlbumId() == albumId) {
                deletedAlbum = album1;
                albumList.remove(album1);
                return deletedAlbum;
            }
        }

        return null;
    }
}
