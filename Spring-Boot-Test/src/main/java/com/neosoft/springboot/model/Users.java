package com.neosoft.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotNull
	@Size(max = 65)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Size(max = 120)
	@Column(unique = true)
	private String email;

	@NotNull
	@Size(max = 15)
	private String password;
	
	//mapping
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	private UsersProfile usersProfile;

	public Users(@NotNull @Size(max = 65) String firstName, @NotNull @Size(max = 65) String lastName,
			@NotNull @Size(max = 120) String email, @NotNull @Size(max = 15) String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public Users() {	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsersProfile getUsersProfile() {
		return usersProfile;
	}

	public void setUsersProfile(UsersProfile usersProfile) {
		this.usersProfile = usersProfile;
	}
	
}
