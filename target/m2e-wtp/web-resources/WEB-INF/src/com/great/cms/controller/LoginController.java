package com.great.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.controller.bean.SignUpBean;
import com.great.cms.db.dao.MainRoutineDao;
import com.great.cms.db.entity.Authorities;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.User;
import com.great.cms.service.AuthorityService;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.MainRoutineService;
import com.great.cms.service.StudentService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("users")
public class LoginController {

	@Autowired
	MainRoutineService mainRoutineService;
	@Autowired
	DepartmentService deptService;
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	UserService userService;
	@Autowired
	MainRoutineDao mrDao;
	
	@Autowired
	AuthorityService authorityService;

	@RequestMapping("/login")
	public String showLogin() {

		return "login";
	}

	@RequestMapping("/signup")
	public String signUp(Model model) {

		model.addAttribute(new SignUpBean());
		return "signup";

	}

	@RequestMapping("/createaccount")
	public String signUpSubmit(Model model,@Valid SignUpBean signUpBean,
			BindingResult result) {
		System.out.println(signUpBean);
		
		if(result.hasErrors()){
			
			return "signup";
		}
		
		User user = new User();
		Authorities authorities = new Authorities();
      
		Teacher teacher = teacherService.getTeacher(signUpBean.getUsername());
		if(teacher!=null){
			 
			String username = teacher.getEmployeeCode() + "_" + teacher.getDeptId().getDeptCode();
			
			user.setUsername(username);
			user.setPassword(signUpBean.getPassword());
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			user.setCredentialsNonExpired(true);
			user.setEnabled(true);
			
			if(userService.createUser(user)){
				
				
				
				authorities.setRole("ROLE_TEACHER");
				authorities.setUserId(user);
				
				if(authorityService.createAuthority(authorities)){
					
					System.out.println("new user created");
					System.out.println("user" + user + "authority "+ authorities);
					
					
				}
				
			}
			
			  
		}
		
		return "home";
	}

}
