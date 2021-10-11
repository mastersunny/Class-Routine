package com.great.cms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.great.cms.db.entity.User;
import com.great.cms.service.UserService;

public class DatabaseAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	public DatabaseAuthenticationProvider() {
		
		System.out.println("Database Authentication Provider Initialized!!");
	}

	@Autowired
	private UserService userService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		System.out.println("readOnly method");
	}

	//this method returns an UserDetails object to spring for security check
	
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
	

    
		
		String password = (String) authentication.getCredentials();
		
		System.out.println("Username:" + username);
		System.out.println("Password: " + password);

		if (!StringUtils.hasText(password)) {
			throw new BadCredentialsException("Please enter password");
		}

		try {
			
			User targetUser = (User) userService.getUser(username);
			System.out.println("target user found: " + targetUser);
			
			if (!password.equals(targetUser.getPassword())) {
				throw new BadCredentialsException("Invalid Password");
			}
			
			System.out.println("Authentication Checking! , TargetUser: "
					+ targetUser);
			return targetUser;

		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
			throw new BadCredentialsException("Invalid user");
		}
	}
}