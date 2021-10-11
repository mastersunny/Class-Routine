package com.great.cms.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component("uservalidation")
public class UserValidation {

	@NotNull
	@Size(min=4,max=100)
	private String userReg;
	
	@Size(min=4,max=100)
	private String password;

	public String getUserReg() {
		return userReg;
	}

	public void setUserReg(String userReg) {
		this.userReg = userReg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserValidation [userReg=" + userReg + ", password=" + password
				+ "]";
	}

}
