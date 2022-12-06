package com.epam.quiz.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.quiz.database.QuizDatabase;
import com.epam.quiz.service.QuizLibrary;

@RestController
public class QuizRestController {
	
	@Autowired
	QuizLibrary quizLibrary;
	
	@RequestMapping("quiz")
	public  ResponseEntity<List<QuizDatabase>> getQuestions()
	{
		
		return new ResponseEntity<>(quizLibrary.getAllQuizes(),HttpStatus.OK);
	}
	
	@PostMapping("quiz/{qid}/{marks}")
	public ResponseEntity<Integer> insertQuiz(@PathVariable("qid") int id,@PathVariable("marks") int marks) {
		ResponseEntity<Integer> responseEntity=null;
	
			
			quizLibrary.addQuestion(id,marks);
			responseEntity= new ResponseEntity<>(id,HttpStatus.CREATED);
	
		return responseEntity;
	}
	
	@DeleteMapping("quiz/{qid}")
	public ResponseEntity<Void> deletebyId(@PathVariable(value = "qid") int qn) {
			
				
				
				quizLibrary.remove(qn);
			
			return ResponseEntity.noContent().build();
	}
	
	@PutMapping("quiz/{quizid}/{questid}/{marks}")
	public ResponseEntity<Void> editQuiz(@PathVariable(value="quizid") int quizNo,@PathVariable("questid") int questNo,@PathVariable("marks") int marks) {
	
			
			quizLibrary.updateQuiz(quizNo,questNo,marks);

		
		
		return ResponseEntity.noContent().build();

	}
	

}
