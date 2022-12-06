package com.epam.quiz.restcontrollers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.quiz.service.QuizLibrary;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QuizRestController.class)
class QuizRestControllerTest {

	@MockBean
	QuizLibrary quizServiLibrary;
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void testGetQuizzes() throws Exception {
		mockMvc.perform(get("/displayQuiz")).andExpect(status().is(200));
	}
	
	@Test
	void testInsertQuiz() throws Exception
	{
		mockMvc.perform(post("/insertingQuiz/{qid}/{marks}",2,10)).andExpect(status().is(201));
	}
	@Test
	void testEdit()throws Exception{
		mockMvc.perform(put("/updateQuiz/{quizid}/{questid}/{marks}",2,7,20)).andExpect(status().is(204));
		
	}
	@Test
	void testDeleteQuiz() throws Exception
	{
		mockMvc.perform(delete("/deleteQuiz/{qid}",1)).andExpect(status().is(204));

		
	}

}
