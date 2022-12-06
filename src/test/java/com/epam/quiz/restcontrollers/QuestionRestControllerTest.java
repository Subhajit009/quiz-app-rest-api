package com.epam.quiz.restcontrollers;


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

import com.epam.quiz.service.QuestionLibrary;


@ExtendWith(SpringExtension.class)
@WebMvcTest(QuestionRestController.class)
class QuestionRestControllerTest {
	
	@MockBean
	QuestionLibrary questionServices;
	
	@Autowired
	MockMvc mockMvc;
	

	@Test
	void testGetQuestion() throws Exception {
		mockMvc.perform(get("/displayQuestions")).andExpect(status().is(200));
		
		
	}
	@Test
	void testInsert() throws Exception
	{
		mockMvc.perform(post("/inserting/{question}/{a}/{b}/{c}/{d}/{answer}","SUbjit","a","b","c","d",'d')).andExpect(status().is(201));
	}
	@Test
	void testEdit()throws Exception{
		mockMvc.perform(put("/update/{qid}/{question}/{a}/{b}/{c}/{d}/{answer}",1,"new smt","a","b","c","d",'d')).andExpect(status().is(204));
		
	}
	@Test
	void testDelete() throws Exception
	{
		mockMvc.perform(delete("/deleting/{qid}",1)).andExpect(status().is(204));

		
	}

}
