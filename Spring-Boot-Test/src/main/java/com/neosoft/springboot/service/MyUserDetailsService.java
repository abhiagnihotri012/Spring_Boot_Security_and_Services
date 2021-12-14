package com.neosoft.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.myexception.ResourceNotFoundException;
import com.neosoft.springboot.security.MyUserDetail;
import com.neosoft.springboot.security.User;
import com.neosoft.springboot.security.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {		
		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new ResourceNotFoundException("User", "UserName",userName));
		return user.map(MyUserDetail::new).get();
	}
	
}
