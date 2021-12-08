package com.example.getmesocial2;

import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {


	@Autowired
	private UserService userService;


	@Before
	public void saveUser(){

		userService.saveUser(new User("1234","albin","albin@gmail.com","h"));
	}

	@Test
	public void getUser(){

		User user = userService.getById("1234");
		Assert.assertEquals("albin",user.getName());

	}



}
