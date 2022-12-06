package com.epam.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.epam.quiz.database.AdminCredentials;

import com.epam.quiz.repositories.AdminRepo;
import java.util.*;

@Service
public class LoginService {
	

	@Autowired
	AdminRepo adminRepository;
	

	
	public boolean adminLogIn(String adminUsername, int adminPasscode) {
		boolean flag = false;
		
		 List<AdminCredentials> newadmin= (List<AdminCredentials>) adminRepository.findAll();
		 for (AdminCredentials adminCredentials : newadmin) {
			
			 if((adminCredentials.getAdminUsername().equals(adminUsername)) && adminCredentials.getAdminPasscode()==(adminPasscode)) {
				 flag = true;
				 break;
			 }
		}
		
		return flag;
		
	}
	

}

