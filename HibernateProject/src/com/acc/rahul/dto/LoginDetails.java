package com.acc.rahul.dto;

import java.io.Serializable;

import javax.persistence.Entity;


public class LoginDetails implements Serializable{
	
	private String userIdentification;
	private String password;
	/**
	 * @return the userId
	 */
	public String getUserIdentification() {
		return userIdentification;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
