package com.great.cms.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SecurityAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {


	public SecurityAuthenticationSuccessHandler() {
		System.out.println("Security Authentication Success Handler!");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		  

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());

		System.out.println("#ROLES : " + roles.size());

		if (roles.contains("ROLE_STUDENT")) {
			
			System.out.println("ROLE: STUDENT FOUND, REDIRECTING.....");
			response.sendRedirect("student/studentview/");
			
		}else if(roles.contains("ROLE_TEACHER")){
			
			System.out.println("ROLE: TEACHER FOUND, REDIRECTING.....");
			response.sendRedirect("teacher/teacherview/");
		}
		
        else if(roles.contains("ROLE_ADMIN")){
			
			System.out.println("ROLE: ADMIN FOUND, REDIRECTING.....");
			response.sendRedirect("admin/adminview/");
		}
	}
}