package com.neosoft.springboot.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"age","userpass"}) //@JsonIgnoreProperties("age") //class level
@JsonFilter("UserBeanFilter") //for Dynamic filter in service level
public class UserFilterModel {

	public UserFilterModel(String username, String userpass, int age) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.age = age;
	}
	private String username;
	//@JsonIgnore //member level
	private String userpass;
	// @JsonIgnore  //member level
	private int age;
}
