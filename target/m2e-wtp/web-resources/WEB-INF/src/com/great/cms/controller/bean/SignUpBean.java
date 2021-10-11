package com.great.cms.controller.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpBean {

	@NotNull
	@Size(min=3,max=22,message="username must be between 3 and 22 characters")
	private String username;
	@NotNull
	@Size(min=3,max=30,message="password must be between 3 and 30 characters")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUpBean [username=" + username + ", password=" + password
				+ "]";
	}
	
	

}
