package com.neosoft.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.neosoft.springboot.model.UserFilterModel;


@RestController
public class UserFilterModelController {

	private List<UserFilterModel> users = new ArrayList<UserFilterModel>(Arrays.asList(
			new UserFilterModel("Kavita","kavita123",23),
			new UserFilterModel("Arif","a123",24),
			new UserFilterModel("Neha","Neha123",22),
			new UserFilterModel("Vignesh","v123",23),
			new UserFilterModel("Azhan","az123",24)));
	
	//Tested for Static filter
	/*
	@GetMapping("/userfilter")	 
	public List<UserFilterModel> getAllUserFilter(){
		return users;
	}
	*/
	
	//Dynamic filtering for every service
	@GetMapping("/userfilter/age")  //applying dynamic filter for all except age
	public MappingJacksonValue getAllUserFilterAge(){
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("age");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(users);
		mapping.setFilters(filters);
		return mapping;		
	}
	
	@GetMapping("/userfilter/ageAndname")  //applying dynamic filter for all except age and name
	public MappingJacksonValue getAllUserFilterAgeAndName(){
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("age","username");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(users);
		mapping.setFilters(filters);
		return mapping;	
	}
	
}
