package com.example.getmesocial2;

import com.example.getmesocial2.model.Album;
import com.example.getmesocial2.service.AlbumService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumServiceTests {


	@Autowired
	private AlbumService albumService;


	@Before
	public void saveAlbum(){

		albumService.saveAlbum(new Album("1","albin","","",new Date()));
	}

	@Test
	public void getAllAlbum(){

		List<Album> album = albumService.getAllAlbum();

		Assert.assertEquals(1,album.size());

	}

	@Test
	public void getById() {

		List<Album> album = albumService.getById("1");
		Assert.assertEquals(1,album.size());

	}


	@Test
	public void updateAlbumById() {

		Album album = new Album("1","albin","aaa","",new Date());
		albumService.updateAlbumById(album);
		List<Album> album1 = albumService.getById("1");
		Assert.assertEquals("aaa",album1.get(0).getCoverPhotoUrl());







	}

	@Test
	public void deleteAlbum() {

		albumService.deleteAlbum("1");
		List<Album> album = albumService.getAllAlbum();
		Assert.assertEquals(0,album.size());



	}












}
