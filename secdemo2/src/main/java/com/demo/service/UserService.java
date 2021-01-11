package com.demo.service;

import java.util.List;


import com.demo.repo.User;

public interface UserService {

	public User findByName(String Name);
	public void addUser(User user);
	
	public List<User> getAllUsers();
    public User getUserById(int id);
    
    
    public User updateBook(int id , User user);
    public User deleteBook(int id);
}
