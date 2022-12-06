package com.epam.quiz.service;

import static org.mockito.ArgumentMatchers.isA;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.quiz.database.AdminCredentials;
import com.epam.quiz.database.QuestionDatabase;
import com.epam.quiz.repositories.AdminRepo;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {
	
	@Mock
	AdminRepo adminRepository;
	
	@Mock
	ModelMapper modelMapper;



	@InjectMocks
	LoginService loginService;



	AdminCredentials createdAdmin;
	
	@BeforeEach
	void setup()
	{
		createdAdmin=new AdminCredentials();
		createdAdmin.setAdminUsername("Sub");
		createdAdmin.setAdminPasscode(123);
		
	}
	
	@Test
	void testAdminLogin() {
		doReturn(List.of(createdAdmin)).when(adminRepository).findAll();
		boolean b = loginService.adminLogIn("Sub", 123);
		assertEquals(true,b);
		}

}
