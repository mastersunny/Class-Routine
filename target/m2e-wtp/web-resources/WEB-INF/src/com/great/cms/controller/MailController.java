package com.great.cms.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.service.UserService;

@Controller
@RequestMapping("mail")
public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	UserService userService;

	@RequestMapping(value = "emailsend", method = RequestMethod.POST)
	@ResponseBody
	public String emailSend(@RequestParam String emailAddress,
			String regNumber, String role) {

		String password = userService.generatePassword();
		final String email = emailAddress;
		final String password1 = password;
		String Role = role;
		String userReg = regNumber;

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper messageHelper = new MimeMessageHelper(
						mimeMessage, true, "UTF-8");

				// messageHelper.setFrom("sunnycse250@gmail.com");
				messageHelper.setTo(email);
				messageHelper.setSubject("Your new password");
				messageHelper
						.setText("Hello sir your password is given below:\n"
								+ password1);

			}
		};

		try {

			mailSender.send(preparator);
			userService.signUp(userReg, password, Role);
			return "ok";

		} catch (MailException e) {

			System.out.println(e.getMessage());
			return "Problem";

		}

	}

}
