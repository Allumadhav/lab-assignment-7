package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.repo.User;
import com.demo.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User findByName(String name) {
		userRepo.findByName(name);
		return null;
	}

	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		Optional <User> user=userRepo.findById(id);
    	return user.orElse((User) userRepo.findAll());

	}

	@Override
	public User updateBook(int id, User user) {
		User userToBeUpdated =getUserById(id);
		userToBeUpdated.setPrice(user.getPrice());
		userRepo.save(userToBeUpdated);
		return userToBeUpdated;
	}

	@Override
	public User deleteBook(int id) {
		User userToBeDeleted=getUserById(id);
		userRepo.delete(userToBeDeleted);
		return userToBeDeleted;
	}

}
