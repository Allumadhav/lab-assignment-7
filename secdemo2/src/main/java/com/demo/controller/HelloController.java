package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.repo.User;
import com.demo.service.UserService;

@RestController
public class HelloController {

	@GetMapping(path = "/home")
	public String home() {
		return "hello to home";
	}

	@GetMapping(path = "/admin")
	public String homeAdmin() {
		return "hello to admin";
	}

	// ===========================================================================================================
	@Autowired
	private UserService userService;

	@GetMapping(path = "/admin2", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}

	@GetMapping(path = "admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable(name = "id") int id) {
		User user = userService.getUserById(id);
		return user;
	}

	@PutMapping(path = "book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateAnUser(@PathVariable(name = "id") int id, @RequestBody User user) {
		User updatedbook = userService.updateBook(id, user);
		return updatedbook;
	}

	@DeleteMapping(path = "book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User deleteUser(@PathVariable(name = "id") int id) {
		User deletedbook = userService.deleteBook(id);
		return deletedbook;
	}
	// ===================================================================================================
	/*
	 * @GetMapping(path="mgr") public String homeMgr(){ return "hello to mgr"; }
	 */

	@GetMapping(path = "/emp")
	public String homeEmp() {
		return "hello to emp";
	}
}
