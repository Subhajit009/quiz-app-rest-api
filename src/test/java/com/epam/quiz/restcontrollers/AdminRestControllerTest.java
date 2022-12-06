package com.epam.quiz.restcontrollers;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.quiz.database.AdminCredentials;
import com.epam.quiz.service.LoginService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminRestController.class)
class AdminRestControllerTest {

	@MockBean
	LoginService loginService;
	@Autowired
	MockMvc mockMvc;
	
	
	
	
	@Test
	void testCheckLogin() throws Exception
	{
		mockMvc.perform(post("/loginCheck/{name}/{password}","Sub",123)).andExpect(status().is(400));
	}
	

	

}
