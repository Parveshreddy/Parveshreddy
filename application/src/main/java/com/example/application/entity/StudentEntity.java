package com.example.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "B31students")

  public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "Last_Name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	
	@Column(name = "phoneNumber", nullable = false)
	private long phoneNumber;
	
	@Column(name = "password", nullable = false)
	private String password;
	
     public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StudentEntity(){
	    	
	}
	public StudentEntity(long id,String firstname,String lastName,long phoneNumber,String email,String password) {
		   
       this.id=id;
	   this.firstName=firstname;
	   this.lastName=lastName;
	   this.phoneNumber=phoneNumber;
	   this.email=email;
	   this.password=password;
	   }
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}
	
	}
