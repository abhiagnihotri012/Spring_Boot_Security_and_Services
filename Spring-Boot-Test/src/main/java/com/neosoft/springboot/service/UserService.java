package com.neosoft.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.model.User;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {
	
	private List<User> users = new ArrayList<User>(Arrays.asList(
			new User(101,"Kavita","kavita123"),
			new User(102,"Vishal","v123"),
			new User(103,"Sarwar","s123"),
			new User(104,"Saba","sa123"),
			new User(105,"Smita","sm123")));	
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUser(int id) {
		return users.stream().filter(u -> u.getUid() == id).findFirst().get();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(int id) {
		users.removeIf(u -> u.getUid() == id);
	}
	
	public void updateUser(User user,int id) {
		users.replaceAll(u -> {
			if(u.getUid() == id)
				u = user;
			return u;
		});
	}
	
	//SortByUname	
	public List<User> sortByUname(){
		Comparator<User> byNameComparator = Comparator.comparing(User::getUname);
		return users.stream().sorted(byNameComparator).collect(Collectors.toList());
	}
	
	//SortByUId reversed
	public List<User> sortByUid(){
		Comparator<User> byIdComparator = Comparator.comparing(User::getUid).reversed();
		return users.stream().sorted(byIdComparator).collect(Collectors.toList());
	}
	
	//========== Testing spring Boot Cache ==========
	@Cacheable
	public List<User> findAll(){
		slowService(); //Wait 3 seconds before execute logic inside find all
		return this.users;
	}
	
	private void slowService() {
		try {
			Thread.sleep(3000L);
		}
		catch(InterruptedException e) {
			e.printStackTrace();		
		}
	}
	
}
