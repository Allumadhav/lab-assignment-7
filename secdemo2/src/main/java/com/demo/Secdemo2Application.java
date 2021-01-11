package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.repo.User;
import com.demo.service.UserService;

@SpringBootApplication
public class Secdemo2Application implements CommandLineRunner{
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(Secdemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * User user1=new User("admin","admin123","chennai",56000,5,2,new String[]
		 * {"ROLE_ADMIN","ROLE_EMP"}); User user2=new
		 * User("emp","emp123","kolkata",24000,3,10,new String[] {"ROLE_EMP"});
		 * 
		 * userService.addUser(user1); userService.addUser(user2);
		 */
	}

}






