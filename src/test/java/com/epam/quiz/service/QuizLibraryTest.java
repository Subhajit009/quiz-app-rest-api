package com.epam.quiz.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
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
import org.mockito.BDDMockito.Then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.epam.quiz.database.QuestionDatabase;
import com.epam.quiz.database.QuizDatabase;
import com.epam.quiz.repositories.QuestionRepo;
import com.epam.quiz.repositories.QuizRepo;

@ExtendWith(MockitoExtension.class)
class QuizLibraryTest {
	
	@Mock
	QuestionRepo questionRepository;
	@Mock
	QuizRepo quizRepository;
	@Mock
	ModelMapper modelMapper;



	@InjectMocks
	QuizLibrary quizServices;
	
	@InjectMocks
	QuestionLibrary questionServicesLibrary;
	
//	@InjectMocks
//	QuestionLibrary questionLibrary;

//
//	@BeforeEach
//	void setUp() throws Exception {
//	}

	@Test
	void testAddQuizz() {
		QuestionDatabase questionFromDb=new QuestionDatabase();
		QuizDatabase quizDatabase=new QuizDatabase();
		questionFromDb.setQuest("mock");
		questionFromDb.setId(1);
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
		//quizServices.addQuestion(1, 20);
		when(quizRepository.save(Mockito.any(QuizDatabase.class))).thenReturn(quizDatabase);
		//doReturn(quizDatabase).when(quizRepository).save(any(QuizDatabase.class);
		assertNotNull( quizServices.addQuestion(1,20));
	}
	
	@Test
	void testRemoveQuiz()
	{
		QuizDatabase quiz = new QuizDatabase();
		QuestionDatabase question = new QuestionDatabase();
		question.setId(100);
		quiz.setId(100);
		doReturn(Optional.of(quiz)).when(quizRepository).findById(100);
		doNothing().when(quizRepository).deleteById(100);
		quizServices.remove(100);
		verify(quizRepository,atLeast(1)).deleteById(100);
	}
	
	@Test
	void TestUpdateQuiz()
	{
		QuestionDatabase questionFromDb=new QuestionDatabase();
		QuizDatabase quizDatabase=new QuizDatabase();
		questionFromDb.setQuest("mock");
		questionFromDb.setId(1);
		questionFromDb.setA("hello");
		questionFromDb.setB("hello");
		questionFromDb.setC("hello");
		questionFromDb.setD("hello");
		questionFromDb.setAnsWer('a');
		doReturn(Optional.of(questionFromDb)).when(questionRepository).findById(1);
		doReturn(Optional.of(quizDatabase)).when(quizRepository).findById(1);
		assertEquals(true, quizServices.updateQuiz(1, 1, 1));
		
		
		
	}
//	@Test
//	void TestUpdateQuizForNull()
//	{
//		QuestionDatabase questionFromDb=new QuestionDatabase();
//		QuizDatabase quizDatabase=new QuizDatabase();
//		questionFromDb.setQuest("mock");
//		questionFromDb.setId(1);
//		questionFromDb.setA("hello");
//		questionFromDb.setB("hello");
//		questionFromDb.setC("hello");
//		questionFromDb.setD("hello");
//		questionFromDb.setAnsWer('a');
//		doReturn(Optional.of(questionFromDb)).when(questionRepository).findById(1);
//		doReturn(Optional.empty()).when(quizRepository).findById(1);
//		assertEquals(false, quizServices.updateQuiz(1, 1, 1));
//		
//		
//		
//	}
	@Test
	void testGetQuizez()
	{
		QuizDatabase quizDatabase=new QuizDatabase();
		quizDatabase.setA("hello");
		quizDatabase.setB("hello");
		quizDatabase.setC("hello");
		quizDatabase.setD("hello");
		quizDatabase.setAnsWer('a');
		List<QuizDatabase> quiz = new ArrayList<>();
		quiz.add(quizDatabase);
		doReturn(quiz).when(quizRepository).findAll();
		assertEquals(quiz, quizServices. getAllQuizes());	
	}

}
