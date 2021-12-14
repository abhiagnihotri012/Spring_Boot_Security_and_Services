package com.neosoft.springboot;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neosoft.springboot.model.Gender;
import com.neosoft.springboot.model.Users;
import com.neosoft.springboot.model.UsersProfile;
import com.neosoft.springboot.repository.UsersProfileRepository;
import com.neosoft.springboot.repository.UsersRepository;

//@SpringBootApplication
public class MappingMainApplication { //implements CommandLineRunner {

//	@Autowired
//	private UsersRepository usersRepository;
	
//	public static void main(String[] args) {
//		SpringApplication.run(MappingMainApplication.class, args);
//	}

//	@Override
//	public void run(String... args) throws Exception {		
//		//create a user instance
//		Users user = new Users("Sarwar", "abcdS", "abcdS@gmail.com", "Sabcd123");
//		
//		Calendar dob = Calendar.getInstance();
//		dob.set(1992, 5, 28);
//		//User profile instance
//		UsersProfile userProfile = new UsersProfile("98900000", Gender.MALE, 
//				dob.getTime(), "c-101", "Pune", "MH", "India", "411002");
//		
//		//set child references in parent entity
//		user.setUsersProfile(userProfile);
//		//set parent references in child entity
//		userProfile.setUsers(user);
//		
//		//Save parent reference also will save child ref as well)
//		usersRepository.save(user);	
//		
//		//usersRepository.deleteById((long) 4);			
//		
//	}
}
