package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.repo.User;
import com.demo.service.UserService;

@Service
public class DetailService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.findByName(username);
		if(user==null)
			throw new UsernameNotFoundException("user with name"+username+"is not found");
		org.springframework.security.core.userdetails.User
		secUser= new org.springframework.security.core.userdetails.User
		(user.getName(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRoles()));
		return secUser;
	}

}
