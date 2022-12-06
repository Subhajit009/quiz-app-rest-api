package com.epam.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.quiz.service.LoginService;
import com.epam.quiz.database.AdminCredentials;



@Controller
public class AdminController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping("admin_operation")
	public String adminLogin() {
		return "admin_operation";
	}

	@RequestMapping("AdminOperations")
	public String AdminOp() {
		return "AdminOperations";
	}

	@PostMapping("checkLogin")
		public ModelAndView checkAdminLogin(AdminCredentials admin) {
		ModelAndView mv = new ModelAndView();
		if(loginService.adminLogIn(admin.getAdminUsername(),admin.getAdminPasscode())) {
		
			mv.addObject("message","Login Successful");
			mv.setViewName("successLogin");
		}
		else {
			mv.addObject("message","Invalid Credentials");
			mv.setViewName("admin_operation");
		}
		return mv;
		
	}

}
