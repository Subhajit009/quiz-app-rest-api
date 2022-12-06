package com.epam.quiz.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.epam.quiz.service.LoginService;

@RestController
public class AdminRestController
{
	
@Autowired
LoginService loginService;


	@PostMapping("loginCheck/{name}/{password}")
		public ResponseEntity<String> checkLogin(@PathVariable("name") String adminUsername,@PathVariable("password")int adminPasscode)
	{
		
		if(loginService.adminLogIn(adminUsername,adminPasscode)) 
		{
			return new ResponseEntity<>("valid credentials",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("wrong credentials",HttpStatus.BAD_REQUEST);
		}
	}

}
