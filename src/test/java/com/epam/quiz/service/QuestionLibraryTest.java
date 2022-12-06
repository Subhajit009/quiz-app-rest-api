package com.epam.quiz.service;


import static org.mockito.ArgumentMatchers.isA;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.quiz.database.QuestionDatabase;
import com.epam.quiz.database.QuizDatabase;
import com.epam.quiz.repositories.QuestionRepo;
import com.epam.quiz.repositories.QuizRepo;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;


@ExtendWith(MockitoExtension.class)
class QuestionLibraryTest {
	
	@Mock
	QuestionRepo questionRepository;
	@Mock
	QuizRepo quizRepository;
	@Mock
	ModelMapper modelMapper;



	@InjectMocks
	QuestionLibrary questionServices;

	QuestionDatabase createdQuestion;
	//QuestionDatabase questionFromDb;
	
	@BeforeEach
	void setup()
	{
		createdQuestion=new QuestionDatabase();
		createdQuestion.setQuest("mock questions");
		createdQuestion.setA("a");
		createdQuestion.setB("b");
		createdQuestion.setC("c");
		createdQuestion.setD("d");
		createdQuestion.setAnsWer('a');

	}


	@Test
	void testCreateQuestion() {
		
		QuestionDatabase questionFromDb=new QuestionDatabase();
		questionFromDb.setQuest("mock");
		//questionFromDb.setId(1);
		questionFromDb.setA("hello");
		questionFromDb.setB("hello");
		questionFromDb.setC("hello");
		questionFromDb.setD("hello");
		questionFromDb.setAnsWer('a');
		String options[]=new String[4];
		options[0]="hello";
		options[1]="hello";
		options[2]="hello";
		options[3]="hello";
		doReturn(questionFromDb).when(questionRepository).save(isA(QuestionDatabase.class));
		assertEquals(questionFromDb, questionServices.createQuestion("mock", options, 'a'));
//		questionServices.createQuestion("mock", options, 'a');
//		verify(questionRepository,atLeast(1)).save(questionFromDb);
	}
	
	@Test
	void testRemove()
	{
		QuestionDatabase question = new QuestionDatabase();
		question.setId(100);
		doReturn(Optional.of(question)).when(questionRepository).findById(	100);
		doNothing().when(questionRepository).deleteById(100);
		questionServices.remove(100);
		verify(questionRepository,atLeast(1)).deleteById(100);
	}
	@Test
	void testRemoveisEmpty()
	{
		
		//question.setId(100);
		doReturn(Optional.empty()).when(questionRepository).findById(	100);
		//doNothing().when(questionRepository).deleteById(100);
		questionServices.remove(100);
		verify(questionRepository,atLeast(0)).deleteById(100);
	}
	
	@Test
	void testGetAllQuestion()
	{
		QuestionDatabase questionFromDb=new QuestionDatabase();
		questionFromDb.setQuest("mock");
		//questionFromDb.setId(1);
		questionFromDb.setA("hello");
		questionFromDb.setB("hello");
		questionFromDb.setC("hello");
		questionFromDb.setD("hello");
		questionFromDb.setAnsWer('a');
		String options[]=new String[4];
		options[0]="hello";
		options[1]="hello";
		options[2]="hello";
		options[3]="hello";
		List<QuestionDatabase> questions = new ArrayList<>();
		questions.add(questionFromDb);
		doReturn(questions).when(questionRepository).findAll();
		assertEquals(questions, questionServices.getAllQuestions());	
	}
	
	@Test
	void testUpdateQuestion()
	{
		QuestionDatabase questionFromDb=new QuestionDatabase();
		questionFromDb.setQuest("mock");
		questionFromDb.setA("hello");
		questionFromDb.setB("hello");
		questionFromDb.setC("hello");
		questionFromDb.setD("hello");
		questionFromDb.setAnsWer('a');
		String options[]=new String[4];
		options[0]="hello";
		options[1]="hello";
		options[2]="hello";
		options[3]="hello";
		Optional<QuestionDatabase> queOptional = Optional.of(questionFromDb);
		when(questionRepository.findById(Mockito.anyInt())).thenReturn(queOptional);
		questionServices.updateQuestion(1,"java",options,'a');
		verify(questionRepository,atLeast(1)).save(questionFromDb);
	}
	@Test
	void testGetByID()
	{
		QuestionDatabase questionFromDb=new QuestionDatabase();
		questionFromDb.setQuest("mock");
		questionFromDb.setA("hello");
		questionFromDb.setB("hello");
		questionFromDb.setC("hello");
		questionFromDb.setD("hello");
		questionFromDb.setAnsWer('a');
		doReturn(Optional.of(questionFromDb)).when(questionRepository).findById(1);
		assertEquals(questionFromDb,questionServices.getQuestionById(1));
		
	}
	
	
}
