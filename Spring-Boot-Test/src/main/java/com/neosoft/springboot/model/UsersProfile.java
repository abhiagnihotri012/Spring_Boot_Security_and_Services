package com.neosoft.springboot.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users_profile")
public class UsersProfile {

	@Id
	@Column(name = "user_profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 15)
	@NotNull
	@Column(name = "phone_number", unique = true)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)	
	private Gender gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dateOfBirth;
	
	@Size(max = 100)
	private String addressLine;
	
	@Size(max = 100)
	private String city;
	
	@Size(max = 100)
	private String state;
	
	@Size(max = 100)
	private String country;
	
	@Size(max = 10)
	@Column(name = "zip_code")
	private String zipCode;
	
	//mapping 1-1
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users users;
	
	public UsersProfile() {	}

	public UsersProfile(@Size(max = 12) @NotNull String phoneNumber, Gender gender, Date dateOfBirth,
			@Size(max = 100) String addressLine, @Size(max = 100) String city, @Size(max = 100) String state,
			@Size(max = 100) String country, @Size(max = 10) String zipCode) {
		super();
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}	
	
}
