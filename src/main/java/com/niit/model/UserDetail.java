package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class UserDetail {
	@Id
	@GeneratedValue
	int userId;
	String firstName;
	String lastName;
	String emailId;
	String password;
	String role;
	String status;
	String isOnline;
	public int getUserId() {
	return userId;
	}
	public void setUserId(int userId) {
	this.userId = userId;
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
	public String getEmailId() {
	return emailId;
	}
	public void setEmailId(String emailId) {
	this.emailId = emailId;
	}
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	public String getRole() {
	return role;
	}
	public void setRole(String role) {
	this.role = role;
	}
	public String getStatus() {
	return status;
	}
	public void setStatus(String status) {
	this.status = status;
	}
	public String getIsOnline() {
	return isOnline;
	}
	public void setIsOnline(String isOnline) {
	this.isOnline = isOnline;
	}
	
}
