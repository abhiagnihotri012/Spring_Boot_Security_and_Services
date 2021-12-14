package com.neosoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.User;
import com.neosoft.springboot.service.UserService;

@RestController
public class UserController {
	
	//We are injecting business service class
	@Autowired
	private UserService userService;

	//http://localhost:8085/users
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	//http://localhost:8085/user/104
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	// or @RequestMapping(method = RequestMethod.PUT,value = "/user/{id}")
	@PutMapping("/user/{id}")
	public void updateUser(@RequestBody User user,@PathVariable int id) {
		userService.updateUser(user, id);
	}	
	
	@GetMapping("/users/sortByUname")
	public List<User> getUsersSortedByUname(){
		return userService.sortByUname();
	}
	
	@GetMapping("/users/sortByUid")
	public List<User> getUsersSortedByUid(){
		return userService.sortByUid();
	}
	
	//========== Testing spring Boot Cache ==========
	// or @RequestMapping(method = RequestMethod.GET,value = "/all")
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.findAll();
	}	
}
